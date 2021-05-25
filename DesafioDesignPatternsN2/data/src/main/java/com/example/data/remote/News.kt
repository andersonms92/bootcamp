package com.example.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface News {
    //https://newsapi.org/v2/everything?q=tecnology&
    @GET("v2/everything?q=tecnology")
    fun getTecnologyNews(
        @Query("apiKey") apiKey: String = "c26a3c60aa3e4a02a946270050ec6aec"
    )
}