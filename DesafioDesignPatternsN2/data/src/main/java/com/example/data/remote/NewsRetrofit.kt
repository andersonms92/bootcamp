package com.example.data.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofit {

    private val api: NewsApi
    var url: String = ""

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(NewsApi::class.java)
    }

    fun getNews(
        page: Int = 1,
        onSuccess: (news: List<ArticlesModel>) -> Unit,
        onError: () -> Unit
    ) {
        api.getArticles(page = page, q = url)
            .enqueue(object : Callback<NewsModel> {
                override fun onResponse(
                    call: Call<NewsModel>,
                    response: Response<NewsModel>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.articles)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}