package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crazyhackathon.data.PlaceData
import com.example.crazyhackathon.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.text = intent.getStringExtra("title")
        binding.tvHead.text = intent.getStringExtra("head")
        binding.tvBody.text = intent.getStringExtra("body")
        binding.tvHeart.text = intent.getStringExtra("heart")
    }

    private fun settingView() {
        //TODO 서버값 받기
    }
}