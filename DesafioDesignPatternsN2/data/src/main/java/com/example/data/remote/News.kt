package com.example.data.remote

data class News(
    val status: String,
    val totalResults: Long,
    val articles: List<Articles>
)

