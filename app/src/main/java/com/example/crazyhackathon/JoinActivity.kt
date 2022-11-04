package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.crazyhackathon.data.JoinData
import com.example.crazyhackathon.data.Gender
import com.example.crazyhackathon.data.JoinResponse
import com.example.crazyhackathon.databinding.ActivityJoinBinding
import com.example.crazyhackathon.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityJoinBinding
    private var age_cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingSpinner()
        genderBtnCheck()
        settingListener()
    }

    private fun genderBtnCheck() {
        binding.checkMale.setOnCheckedChangeListener { _, _ ->
            binding.checkFemale.isChecked = false
        }
        binding.checkFemale.setOnCheckedChangeListener { _, _ ->
            binding.checkMale.isChecked = false
        }
    }
    private fun checkJoin() {
        if(binding.etName.text.isNullOrBlank()) {
            Toast.makeText(this, "이름을 입력해주세요!", Toast.LENGTH_SHORT).show()
            binding.etName.requestFocus()
        } else if(binding.etId.text.isNullOrBlank()) {
            Toast.makeText(this, "아이디를 입력해주세요!", Toast.LENGTH_SHORT).show()
            binding.etId.requestFocus()
        } else if (binding.etPw.text.isNullOrBlank()) {
            Toast.makeText(this, "비밀번호를 입력해주세요!", Toast.LENGTH_SHORT).show()
            binding.etPw.requestFocus()
        } else {
            val name = binding.etName.text.toString()
            val id = binding.etId.text.toString()
            val pw = binding.etPw.text.toString()
            val age = age_cnt
            val gender = if (binding.checkMale.isChecked)  Gender.MALE else Gender.FEMALE
            val data = JoinData(age, gender, id, name, pw)
            Log.d("testasd", data.toString())
            JoinPost(data)
        }
    }

    private fun JoinPost(joinData: JoinData) {
        RetrofitBuilder.api.JoinPost(joinData).enqueue(object :
            Callback<JoinResponse> {
            override fun onResponse(
                call: Call<JoinResponse>,
                response: Response<JoinResponse>,
            ) {
                Log.d("testasd", response.toString())
                if (response.isSuccessful) {
                    finish()
                }
            }

            override fun onFailure(call: Call<JoinResponse>, t: Throwable) {
                Log.d("testasd", "실패 : $t")
            }

        })
    }

    private fun settingSpinner() {
        binding.spinnerAge.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.ageList,
            android.R.layout.simple_spinner_item
        )
        binding.spinnerAge.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.spinnerAge.prompt = "나이"
                when(p2) {
                    0 -> {
                        age_cnt = 10
                    }
                    1 -> {
                        //10
                        age_cnt = 20
                    }
                    2 -> {
                        //20
                        age_cnt = 30
                    }
                    3 -> {
                        //30
                        age_cnt = 40
                    }
                    4 -> {
                        //40
                        age_cnt = 50
                    }
                    5 -> {
                        //50
                        age_cnt = 60
                    }
                    6 -> {
                        //60
                        age_cnt = 70
                    }
                    7 -> {
                        //70
                        age_cnt = 80
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    private fun settingListener(){
        binding.btnJoin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnJoin -> {
                checkJoin()
            }
        }
    }
}