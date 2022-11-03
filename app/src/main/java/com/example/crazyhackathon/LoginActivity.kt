package com.example.crazyhackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import com.example.crazyhackathon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etPw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        settingListener()
    }

    private fun settingListener() {
        binding.btnLogin.setOnClickListener(this)
        binding.btnJoin.setOnClickListener(this)
        binding.imgPwView.setOnClickListener(this)
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
            binding.imgPwView -> {
                if (binding.imgPwView.tag.equals("0")) {
                    binding.imgPwView.tag = "1"
                    binding.imgPwView.setImageResource(R.drawable.open)

                    binding.etPw.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                } else {
                    binding.imgPwView.tag = "0"
                    binding.imgPwView.setImageResource(R.drawable.close)

                    binding.etPw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
                binding.etPw.setSelection(binding.etPw.text.length)
            }
        }
    }
}