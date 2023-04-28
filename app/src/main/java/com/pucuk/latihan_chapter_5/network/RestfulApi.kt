package com.pucuk.latihan_chapter_5.network

import com.pucuk.latihan_chapter_5.model.ResponseDataFilmItem
import com.pucuk.latihan_chapter_5.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>

    @GET("film")
    fun getAllFilm(): Call<List<ResponseDataFilmItem>>
}