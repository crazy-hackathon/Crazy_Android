package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crazyhackathon.data.PlaceData
import com.example.crazyhackathon.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    var dataList = mutableListOf<PlaceData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingView()
    }

    private fun settingView() {
        //TODO 서버값 받기
    }
}