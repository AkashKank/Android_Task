package com.example.demoapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/253620?lang=en&store=KWD")
    fun getData():Call<responceDataClass>
}