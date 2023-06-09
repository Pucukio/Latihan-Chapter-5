package com.pucuk.latihan_chapter_5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pucuk.latihan_chapter_5.model.*
import com.pucuk.latihan_chapter_5.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel: ViewModel() {

    val liveDataNews = MutableLiveData<List<ResponseDataNewsItem>>()
    private val postDataNews = MutableLiveData<ResponseAddNews>()
    private val updateDataNews = MutableLiveData<List<ResponseUpdateNews>>()
    private val deleteDataNews = MutableLiveData<ResponseDeleteNews>()


    fun getDataNews(): MutableLiveData<List<ResponseDataNewsItem>> {
        return liveDataNews
    }

    fun postNews(): MutableLiveData<ResponseAddNews> {
        return postDataNews
    }

    fun updateNews(): MutableLiveData<List<ResponseUpdateNews>> {
        return updateDataNews
    }

    fun deleteNews(): MutableLiveData<ResponseDeleteNews> {
        return deleteDataNews
    }

    fun callApiNews() {
        RetrofitClient.instance.getAllNews()
            .enqueue(object : Callback<List<ResponseDataNewsItem>> {
                override fun onResponse(
                    call: Call<List<ResponseDataNewsItem>>,
                    response: Response<List<ResponseDataNewsItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataNews.postValue(response.body())
                    } else {
                        liveDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }
            })
    }

    fun addDataNews(title: String, image: String, author: String, description: String) {
        RetrofitClient.instance.postDataNews(DataNews(title, image, author, description))
            .enqueue(object : Callback<ResponseAddNews> {
                override fun onResponse(
                    call: Call<ResponseAddNews>,
                    response: Response<ResponseAddNews>
                ) {
                    if (response.isSuccessful) {
                        postDataNews.postValue(response.body())
                    } else {
                        postDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseAddNews>, t: Throwable) {
                    postDataNews.postValue(null)
                }
            })
    }

    fun updateDataNews(id: Int, title: String, image: String, author: String, description: String) {
        RetrofitClient.instance.updateDataNews(id, DataNews(title, image, author, description))
            .enqueue(object : Callback<List<ResponseUpdateNews>> {
                override fun onResponse(
                    call: Call<List<ResponseUpdateNews>>,
                    response: Response<List<ResponseUpdateNews>>
                ) {
                    if (response.isSuccessful) {
                        updateDataNews.postValue(response.body())
                    } else {
                        updateDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseUpdateNews>>, t: Throwable) {
                    updateDataNews.postValue(null)
                }
            })
    }
    fun deleteDataNews(id: Int) {
        RetrofitClient.instance.deleteDataNews(id)
            .enqueue(object : Callback<ResponseDeleteNews> {
                override fun onResponse(
                    call: Call<ResponseDeleteNews>,
                    response: Response<ResponseDeleteNews>
                ) {
                    if (response.isSuccessful) {
                        deleteDataNews.postValue(response.body())
                    } else {
                        deleteDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseDeleteNews>, t: Throwable) {
                    deleteDataNews.postValue(null)
                }
            })
    }
}


