package com.example.crazyhackathon.retrofit

import com.example.crazyhackathon.data.JoinData
import retrofit2.Call
import retrofit2.http.*

interface API {
    @POST("auth/sign-up")
    fun JoinPost(@Body joinData: JoinData) : Call<Void>
}