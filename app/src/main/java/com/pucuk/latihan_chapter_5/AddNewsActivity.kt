package com.pucuk.latihan_chapter_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.pucuk.latihan_chapter_5.databinding.ActivityAddNewsBinding
import com.pucuk.latihan_chapter_5.viewmodel.NewsViewModel

class AddNewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val image = binding.etAddImage.text.toString()
            val author = binding.etAddAuthor.text.toString()
            val description = binding.etAddDescription.text.toString()
            addNews(title, image, author, description)
        }
    }

    private fun addNews(title: String, image: String, author: String, description: String) {
        val viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.addDataNews(title, image, author, description)
        viewModel.postNews().observe(this) { response ->
            if (response != null) {
                Toast.makeText(this, "Berhasil menambahkan news", Toast.LENGTH_SHORT).show()
                finish() // menutup activity saat berhasil menambahkan news dan kembali ke MainActivity
            } else {
                Toast.makeText(this, "Gagal menambahkan news", Toast.LENGTH_SHORT).show()
            }
        }
    }
}