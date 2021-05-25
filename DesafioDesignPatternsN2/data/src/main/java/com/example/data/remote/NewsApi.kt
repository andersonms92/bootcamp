package com.example.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything?q=tecnologia")
    fun getTecnologyNews(
        @Query("apiKey") apiKey: String = "c26a3c60aa3e4a02a946270050ec6aec",
        @Query("page") page: Int
    ): Call<News>
}