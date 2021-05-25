package com.example.data.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofit {

    private val api: NewsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(NewsApi::class.java)
    }

    fun getTechnologyNews(
        page: Int = 1,
        onSuccess: (news: List<Articles>) -> Unit,
        onError: () -> Unit
    ) {
        api.getTecnologyNews(page = page)
            .enqueue(object : Callback<News> {
                override fun onResponse(
                    call: Call<News>,
                    response: Response<News>
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

                override fun onFailure(call: Call<News>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}