package com.pucuk.latihan_chapter_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pucuk.latihan_chapter_5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()


            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"Register Telah berhasil", Toast.LENGTH_SHORT).show()
                        val move = Intent(this, LoginActivity::class.java)
                        startActivity(move)
                    } else {
                        Toast.makeText(this,"Register Gagal", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        binding.tvLogin.setOnClickListener {
            val move = Intent(this, LoginActivity::class.java)
            startActivity(move)
        }
    }
}