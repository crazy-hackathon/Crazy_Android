package com.example.crazyhackathon.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitBuilder {
    val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
    var api: API
    private var serverIP: String = "172.20.10.3:8080/"

    var gson = GsonBuilder().setLenient().create();

    init {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://" + serverIP)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }
//    init {
//        val retrofit = Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl("http://" + serverIP)
////            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .build()
//
//
//        api = retrofit.create(API::class.java)
//    }
}