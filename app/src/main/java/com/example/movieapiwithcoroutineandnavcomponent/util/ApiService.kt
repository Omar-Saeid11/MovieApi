package com.example.movieapiwithcoroutineandnavcomponent.util

import com.example.movieapiwithcoroutineandnavcomponent.data.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = "300cbeb8d36e791cf85879629cf221f4"
    ): Movie
}