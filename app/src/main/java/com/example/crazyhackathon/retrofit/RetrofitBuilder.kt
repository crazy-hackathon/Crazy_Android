package com.example.crazyhackathon.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    //val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
    var api: API
    private var serverIP: String = "192.168.0.32:8080/"

    init {
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://" + serverIP)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }
}