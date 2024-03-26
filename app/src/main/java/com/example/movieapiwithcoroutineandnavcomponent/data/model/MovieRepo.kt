package com.example.movieapiwithcoroutineandnavcomponent.data.model

import android.content.Context
import com.example.movieapiwithcoroutineandnavcomponent.data.IntRepo
import com.example.movieapiwithcoroutineandnavcomponent.data.local.MovieDatabase
import com.example.movieapiwithcoroutineandnavcomponent.util.API
import com.example.movieapiwithcoroutineandnavcomponent.util.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepo(private val intRepo: IntRepo) {
    private val context: Context = App.getContext()
    suspend fun getMovies() =
        try {
            val response = withContext(Dispatchers.IO) {
                API.apiService.getMovies()
            }
            intRepo.onMovieReceived(response.results)
            getCacheMovie(response.results)
        } catch (e: Exception) {
            getLocalMovie()
        }

    private suspend fun getCacheMovie(list: List<Result>) =
        withContext(Dispatchers.IO) {
            MovieDatabase.getInstance(context).movieDao().insert(list)
        }


    private suspend fun getLocalMovie() {
        val result = withContext(Dispatchers.IO) {
            MovieDatabase.getInstance(context).movieDao().getAllMovies()
        }
        intRepo.onMovieReceived(result)
    }

}