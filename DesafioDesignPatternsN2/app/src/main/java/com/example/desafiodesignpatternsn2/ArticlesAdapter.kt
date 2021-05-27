package com.example.desafiodesignpatternsn2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.data.remote.ArticlesModel

class ArticlesAdapter(
    private var articles: MutableList<ArticlesModel>
) : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticlesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_articles_details, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    fun updateNews(articles: List<ArticlesModel>) {
        this.articles.addAll(articles)
        notifyItemRangeInserted(
            this.articles.size,
            articles.size -1
        )
    }

    inner class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.item_technology_title)
        private val description: TextView = itemView.findViewById(R.id.item_technology_description)
        private val image: ImageView = itemView.findViewById(R.id.item_technology_image)

        fun bind(articlesModel: ArticlesModel) {

            title.text = articlesModel.title
            description.text = articlesModel.description

            Glide.with(itemView)
                .load(articlesModel.urlToImage)
                .transform(CenterCrop())
                .into(image)
        }
    }
}