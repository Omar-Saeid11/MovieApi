package com.example.movieapiwithcoroutineandnavcomponent.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapiwithcoroutineandnavcomponent.data.model.Result
import com.example.movieapiwithcoroutineandnavcomponent.data.IntRepo
import com.example.movieapiwithcoroutineandnavcomponent.data.model.MovieRepo
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel(), IntRepo {
    val movieMutableLiveData = MutableLiveData<List<Result?>?>()
    private val movieRepo: MovieRepo = MovieRepo(this)

    fun getMovies() {
        viewModelScope.launch {
            movieRepo.getMovies()
        }

    }

    override suspend fun onMovieReceived(list: List<Result>) {
        movieMutableLiveData.postValue(list)
    }
}