package com.example.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsApi {
    @GET("v2/everything")
    fun getArticles(
        @Query("apiKey") apiKey: String = "df7de9ae3c254fb5a21a966f213d6310",
        @Query("page") page: Int,
        @Query("q", encoded = true) q: String
    ): Call<NewsModel>

}