package com.example.demoapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://klinq.com/rest/V1/productdetails/6701/").addConverterFactory(GsonConverterFactory.create()).build()

    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}