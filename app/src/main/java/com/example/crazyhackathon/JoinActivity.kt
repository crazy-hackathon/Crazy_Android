package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.crazyhackathon.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingSpinner()
    }

    private fun settingSpinner() {
        binding.spinnerAge.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.ageList,
            android.R.layout.simple_spinner_item
        )
        binding.spinnerAge.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p2) {
                    //선택안함
                    0 -> {
                        Toast.makeText(this@JoinActivity, "나이대를 선택해 주세요!", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        //10
                    }
                    2 -> {
                        //20
                    }
                    3 -> {
                        //30
                    }
                    4 -> {
                        //40
                    }
                    5 -> {
                        //50
                    }
                    6 -> {
                        //60
                    }
                    7 -> {
                        //70
                    }
                    8 -> {
                        //80
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }
}