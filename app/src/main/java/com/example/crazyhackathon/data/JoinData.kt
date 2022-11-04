package com.example.crazyhackathon.data

import com.google.gson.annotations.SerializedName

data class JoinData(

    val age: Int,
    val gender: Gender,
    val id: String,
    val name: String,
    val pw: String
)