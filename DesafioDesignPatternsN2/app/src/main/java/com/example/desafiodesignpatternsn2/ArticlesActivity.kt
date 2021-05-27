package com.example.desafiodesignpatternsn2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.remote.ArticlesModel
import com.example.data.remote.NewsRetrofit

    const val ARTICLE_URL = "extra_article_url"

class ArticlesActivity : AppCompatActivity() {

    private lateinit var articlesRecycleView: RecyclerView
    private lateinit var articlesAdapter: ArticlesAdapter
    private lateinit var articlesLayoutManager: LinearLayoutManager
    private var articleNewsPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_items)

        val button: Button = findViewById(R.id.btn_voltar)

        val extras = intent.extras

        if (extras != null) {
            articlesRecycleView = findViewById(R.id.rv_news)
            articlesLayoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
            articlesRecycleView.layoutManager = articlesLayoutManager
            articlesAdapter = ArticlesAdapter(mutableListOf())
            articlesRecycleView.adapter = articlesAdapter

            extras.getString(ARTICLE_URL)?.let { getNews(it) }
        } else {
            finish()
        }

        button.setOnClickListener {
           finish()
        }
    }

    fun getNews(url: String) {
        NewsRetrofit.url = url
        NewsRetrofit.getNews(
            articleNewsPage,
            ::onNewsFetched,
            ::onError
        )
    }

    fun scrollNews() {
        NewsRetrofit.getNews(
            articleNewsPage,
            ::onNewsFetched,
            ::onError
        )
    }

    private fun attachNewsOnScrollListener() {
        articlesRecycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = articlesLayoutManager.itemCount
                val visibleItemCount = articlesLayoutManager.childCount
                val firstVisibleItem = articlesLayoutManager.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    articlesRecycleView.removeOnScrollListener(this)
                    articleNewsPage++
                    scrollNews()
                }
            }
        })
    }

    private fun onNewsFetched(articles: List<ArticlesModel>) {
        articlesAdapter.updateNews(articles)
        attachNewsOnScrollListener()
    }

    private fun onError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

}