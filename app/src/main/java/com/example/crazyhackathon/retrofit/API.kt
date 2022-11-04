package com.example.crazyhackathon.retrofit

import com.example.crazyhackathon.data.JoinData
import com.example.crazyhackathon.data.JoinResponse
import com.example.crazyhackathon.data.LoginData
import com.example.crazyhackathon.data.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface API {

    @POST("auth/sign-up")
    fun JoinPost(
        @Body joinData: JoinData
    ) : Call<JoinResponse>

    @POST("auth/sign-in")
    fun LoginPost(@Body loginData: LoginData) : Call<LoginResponse>
}