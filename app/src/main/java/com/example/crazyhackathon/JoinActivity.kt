package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.crazyhackathon.data.UserData
import com.example.crazyhackathon.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityJoinBinding
    private var data: UserData = UserData("", "", "", "", 0)

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
            saveData()
        }
    }

    private fun saveData() {
        data.name = binding.etName.text.toString()
        data.id = binding.etId.text.toString()
        data.pw = binding.etPw.text.toString()
        if (binding.checkMale.isChecked){
            data.gender = "male"
        } else if(binding.checkFemale.isChecked){
            data.gender = "female"
        }
        joinPost(data)
        Log.d("test", data.toString())
    }

    private fun joinPost(userData: UserData) {
        //TODO API 연결
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
                        data.age = 1
                    }
                    1 -> {
                        //10
                        data.age = 2
                    }
                    2 -> {
                        //20
                        data.age = 3
                    }
                    3 -> {
                        //30
                        data.age = 4
                    }
                    4 -> {
                        //40
                        data.age = 5
                    }
                    5 -> {
                        //50
                        data.age = 6
                    }
                    6 -> {
                        //60
                        data.age = 7
                    }
                    7 -> {
                        //70
                        data.age = 8
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