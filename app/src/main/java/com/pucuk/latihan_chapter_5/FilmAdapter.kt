package com.pucuk.latihan_chapter_5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pucuk.latihan_chapter_5.databinding.ItemNewsBinding
import com.pucuk.latihan_chapter_5.model.ResponseDataFilmItem
import com.pucuk.latihan_chapter_5.model.ResponseDataNewsItem

//class FilmAdapter(var listFilm : List<ResponseDataFilmItem>): RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
//
//    class ViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.ViewHolder {
//        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding.tvTitleFilm.text = listFilm[position].name
//        holder.binding.tvDateFilm.text = listFilm[position].date
//
//    }
//
//    override fun getItemCount(): Int {
//        return listFilm.size
//    }
//}

