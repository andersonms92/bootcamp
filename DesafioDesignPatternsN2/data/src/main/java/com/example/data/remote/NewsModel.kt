package com.example.data.remote

data class NewsModel(
    val status: String,
    val totalResults: Long,
    val articles: List<ArticlesModel>
)

