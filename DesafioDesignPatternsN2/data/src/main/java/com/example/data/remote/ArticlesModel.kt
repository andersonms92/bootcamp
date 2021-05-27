package com.example.data.remote

data class ArticlesModel(
    val source: Sources,
    val author: String? = null,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

