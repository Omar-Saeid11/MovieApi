package com.example.movieapiwithcoroutineandnavcomponent.util

import android.widget.ImageView
import coil.load
import com.example.movieapiwithcoroutineandnavcomponent.R
import com.google.android.material.imageview.ShapeableImageView

fun ShapeableImageView.loadImageWithPlaceholderAndCrossFade(url: String) {
    this.load(url) {
        crossfade(1500)
        placeholder(R.drawable.ic_load)
        error(R.drawable.ic_error)
    }
}
