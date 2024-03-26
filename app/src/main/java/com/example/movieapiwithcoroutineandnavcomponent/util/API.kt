package com.example.movieapiwithcoroutineandnavcomponent.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object API {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiService= retrofit.create<ApiService>()
}