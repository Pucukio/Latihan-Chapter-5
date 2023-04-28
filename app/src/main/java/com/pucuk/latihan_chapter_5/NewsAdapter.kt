package com.pucuk.latihan_chapter_5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pucuk.latihan_chapter_5.databinding.ItemNewsBinding
import com.pucuk.latihan_chapter_5.model.ResponseDataNews
import com.pucuk.latihan_chapter_5.model.ResponseDataNewsItem

class NewsAdapter(var listNews : List<ResponseDataNewsItem>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.binding.tvTitleNews.text = listNews[position].title
        holder.binding.tvDateNews.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imgViews)

    }

    override fun getItemCount(): Int {
        return listNews.size
    }

}