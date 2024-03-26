package com.example.movieapiwithcoroutineandnavcomponent.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieapiwithcoroutineandnavcomponent.data.Converter
import com.example.movieapiwithcoroutineandnavcomponent.data.model.Result

@Database(entities = [Result::class], version = 1)
@TypeConverters(Converter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private const val DATABASE_NAME = "MOVIE_DATABASE"

        @Volatile
        private var instance: MovieDatabase? = null

         fun getInstance(context: Context): MovieDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MovieDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}