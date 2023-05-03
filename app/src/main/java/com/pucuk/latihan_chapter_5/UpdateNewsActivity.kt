package com.pucuk.latihan_chapter_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.pucuk.latihan_chapter_5.databinding.ActivityUpdateNewsBinding
import com.pucuk.latihan_chapter_5.viewmodel.NewsViewModel

class UpdateNewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityUpdateNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            var id = intent.getStringExtra("update")
            var title = binding.etUpdateTitle.text.toString()
            var image = binding.etUpdateImage.text.toString()
            var author = binding.etUpdateAuthor.text.toString()
            var description = binding.etUpdateDescription.text.toString()


            // Periksa apakah ada data yang belum diisi sebelum memperbarui data
            if (title.isBlank() || image.isBlank() || author.isBlank() || description.isBlank()) {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            } else {
                updateNews(id!!.toInt(), title, image, author, description)
                Toast.makeText(this, "Berita Berhasil di Update", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NewsListActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun updateNews(id: Int, title: String, image: String, author: String, description: String) {
        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.updateDataNews(id, title, image, author, description)
        viewModel.updateNews().observe(this) {
            if (it != null) {
                Toast.makeText(this, "Berita Berhasil di Update", Toast.LENGTH_SHORT).show()
            }
        }
    }
}