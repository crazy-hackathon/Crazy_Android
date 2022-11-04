package com.example.crazyhackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import com.example.crazyhackathon.data.LoginData
import com.example.crazyhackathon.data.LoginResponse
import com.example.crazyhackathon.databinding.ActivityLoginBinding
import com.example.crazyhackathon.retrofit.App
import com.example.crazyhackathon.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                val data = LoginData(binding.etId.text!!.toString(), binding.etPw.text!!.toString())
                LoginPost(data)
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

    private fun LoginPost(loginData: LoginData) {
        RetrofitBuilder.api.LoginPost(loginData).enqueue(object :
            Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>,
            ) {
                Log.d("testasd", response.toString())
                if (response.isSuccessful) {
                    Log.d("testasd", response.body().toString())
//                    var data = response.body() // GsonConverter를 사용해 데이터매핑
//                    App.prefs.name = data?.name
//                    App.prefs.token = data!!.token
//                    val intent = Intent(applicationContext, MainActivity::class.java)
//                    finish()
//                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("testasd", "실패$t")
            }

        })
    }
}