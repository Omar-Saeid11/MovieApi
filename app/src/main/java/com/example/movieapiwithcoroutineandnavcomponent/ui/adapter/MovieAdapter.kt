package com.example.movieapiwithcoroutineandnavcomponent.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapiwithcoroutineandnavcomponent.R
import com.example.movieapiwithcoroutineandnavcomponent.data.model.Result
import com.example.movieapiwithcoroutineandnavcomponent.databinding.MovieItemBinding
import com.example.movieapiwithcoroutineandnavcomponent.util.loadImageWithPlaceholderAndCrossFade

class MovieAdapter(
    private var items: List<Result?>?,
    private val listener: MovieInteractionListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = MovieItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = items?.get(position)
        holder.binding.item = currentItem
        holder.binding.root.setOnClickListener {
            if (currentItem != null) {
                listener.onClickMovie(currentItem)
            }
        }
        holder.binding.apply {
            currentItem?.posterPath?.let {
                imgPoster.loadImageWithPlaceholderAndCrossFade("https://image.tmdb.org/t/p/w500/$it")
            }
        }
    }

    fun setItems(newItems: List<Result?>?) {
        items = newItems
    }

    interface MovieInteractionListener {
        fun onClickMovie(movieResult: Result)
    }
}
