package com.example.movieapiwithcoroutineandnavcomponent.data

import com.example.movieapiwithcoroutineandnavcomponent.data.model.Result

interface IntRepo {
    suspend fun onMovieReceived(list: List<Result>)
}