package com.example.crazyhackathon.data

import com.google.gson.annotations.SerializedName

data class JoinResponse(
    @SerializedName("userId")
    val userId: Int
)