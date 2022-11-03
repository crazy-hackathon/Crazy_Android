package com.example.crazyhackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.crazyhackathon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun settingListener() {
        binding.btnLogin.setOnClickListener(this)
        binding.btnJoin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.btnLogin -> {
                //TODO 로그인
                Intent(this, MainActivity::class.java).run {
                    startActivity(this)
                }
            }
            binding.btnJoin -> {
                Intent(this, JoinActivity::class.java).run {
                    startActivity(this)
                }
            }
        }
    }
}