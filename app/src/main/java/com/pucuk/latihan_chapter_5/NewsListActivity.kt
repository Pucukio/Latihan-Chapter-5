package com.pucuk.latihan_chapter_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pucuk.latihan_chapter_5.adapter.NewsAdapter
import com.pucuk.latihan_chapter_5.databinding.ActivityNewsListBinding
import com.pucuk.latihan_chapter_5.viewmodel.NewsViewModel

class NewsListActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataNews()

        binding.fabTambah.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    override fun onResume() {
        super.onResume()
        showDataNews()
    }

    fun showDataNews() {
        val viewModelNews = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModelNews.callApiNews()
        viewModelNews.liveDataNews.observe(this) {
            if (it != null) {
                binding.rvNews2.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvNews2.adapter = NewsAdapter(it)
            }
        }
    }
}