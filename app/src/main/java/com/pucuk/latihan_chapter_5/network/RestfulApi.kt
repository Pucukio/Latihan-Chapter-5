package com.pucuk.latihan_chapter_5.network

import android.provider.ContactsContract.Data
import com.pucuk.latihan_chapter_5.model.*
import retrofit2.Call
import retrofit2.http.*

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>

    @POST("news")
    fun postDataNews(@Body request: DataNews): Call<ResponseAddNews>

    @PUT("news/{id}")
    fun updateDataNews(
        @Path("id") id: Int,
        @Body request: DataNews
    ) : Call<List<ResponseUpdateNews>>


    @GET("film")
    fun getAllFilm(): Call<List<ResponseDataFilmItem>>

    @DELETE("news/{id}")
    fun deleteDataNews(
        @Path("id") id: Int
    ) : Call<ResponseDeleteNews>
}