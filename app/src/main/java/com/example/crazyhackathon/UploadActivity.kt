package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.crazyhackathon.data.PostData
import com.example.crazyhackathon.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUploadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingListener()
    }

    private fun settingListener(){
        binding.btnUpload.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.btnUpload -> {
                val data = PostData(binding.etTitle.text.toString(), "test123", binding.etLocation.text.toString(), 0,20221012)
                finish()
            }
        }
    }
}