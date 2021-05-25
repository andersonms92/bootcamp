package com.example.desafiodesignpatternsn2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.remote.Articles
import com.example.data.remote.NewsRetrofit

class MainActivity : AppCompatActivity() {

    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var articlesAdapter: ArticlesAdapter
    private lateinit var newsLayoutManager: LinearLayoutManager

    private var technologyNewsPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsRecyclerView = findViewById(R.id.rv_technology_news)
        newsLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        newsRecyclerView.layoutManager = newsLayoutManager
        articlesAdapter = ArticlesAdapter(mutableListOf())
        newsRecyclerView.adapter = articlesAdapter

        getTecnologyNews()

    }

    fun getTecnologyNews() {
        NewsRetrofit.getTechnologyNews(
            technologyNewsPage,
            ::onNewsFetched,
            ::onError
        )
    }

    private fun attachNewsOnScrollListener() {
        newsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = newsLayoutManager.itemCount
                val visibleItemCount = newsLayoutManager.childCount
                val firstVisibleItem = newsLayoutManager.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    newsRecyclerView.removeOnScrollListener(this)
                    technologyNewsPage++
                    getTecnologyNews()
                }
            }
        })
    }


    private fun onNewsFetched(news: List<Articles>) {
        articlesAdapter.updateNews(news)
        attachNewsOnScrollListener()
    }

    private fun onError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}