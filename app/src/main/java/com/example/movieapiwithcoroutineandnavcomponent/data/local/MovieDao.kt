package com.example.movieapiwithcoroutineandnavcomponent.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapiwithcoroutineandnavcomponent.data.model.Result

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(list: List<Result>)

    @Query("SELECT * FROM MOVIE_TABLE")
     fun getAllMovies(): List<Result>
}