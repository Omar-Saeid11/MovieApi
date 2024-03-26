package com.example.movieapiwithcoroutineandnavcomponent.util

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        private lateinit var instance: App

        fun getContext(): Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
