package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
                if (binding.etTitle.text.isNullOrBlank()) {
                    Toast.makeText(this, "제목을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    binding.etTitle.requestFocus()
                } else if(binding.etLocation.text.isNullOrBlank()) {
                    Toast.makeText(this, "위치를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    binding.etLocation.requestFocus()
                } else if(binding.etPost.text.isNullOrBlank()) {
                    Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    binding.etPost.requestFocus()
                } else {
                    val data = PostData(binding.etTitle.text.toString(), "test123", binding.etLocation.text.toString(), 0,20221012)
                    finish()
                }
            }
        }
    }
}