package com.pucuk.latihan_chapter_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pucuk.latihan_chapter_5.databinding.ActivityMainBinding
import com.pucuk.latihan_chapter_5.model.ResponseDataFilmItem
import com.pucuk.latihan_chapter_5.model.ResponseDataNews
import com.pucuk.latihan_chapter_5.model.ResponseDataNewsItem
import com.pucuk.latihan_chapter_5.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataNews()
    }

    fun getDataNews(){
        RetrofitClient.instance.getAllNews().enqueue(object : retrofit2.Callback<List<ResponseDataNewsItem>>{
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if(response.isSuccessful){
                    // show data
                    binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    binding.rvNews.adapter = NewsAdapter(response.body()!!)
                } else {
                    Toast.makeText(this@MainActivity, "Failed load data", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
            }
        })
    }
//    fun getDataFilm(){
//        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataFilmItem>>{
//            override fun onResponse(
//                call: Call<List<ResponseDataFilmItem>>,
//                response: Response<List<ResponseDataFilmItem>>
//            ) {
//                if(response.isSuccessful){
//                    // show data
//                    binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
//                    binding.rvNews.adapter = FilmAdapter(response.body()!!)
//                } else {
//                    Toast.makeText(this@MainActivity, "Failed load data", Toast.LENGTH_SHORT).show()
//                }
//            }
//            override fun onFailure(call: Call<List<ResponseDataFilmItem>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}