package com.example.movieapiwithcoroutineandnavcomponent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.movieapiwithcoroutineandnavcomponent.data.model.Result
import com.example.movieapiwithcoroutineandnavcomponent.databinding.MovieListBinding
import com.example.movieapiwithcoroutineandnavcomponent.ui.adapter.MovieAdapter

class FragmentMovieList : Fragment() {
    private lateinit var binding: MovieListBinding
    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies()
        // Initialize the adapter before using it
        adapter = MovieAdapter(mutableListOf(), object : MovieAdapter.MovieInteractionListener {
            override fun onClickMovie(movieResult: Result) {
                val action =
                    FragmentMovieListDirections.actionFragmentMovieListToDetailsFragment(movieResult)
                findNavController().navigate(action)
            }
        })
        viewModel.movieMutableLiveData.observe(viewLifecycleOwner) { movies ->
            adapter.setItems(movies)
            binding.recyclerMovies.adapter = adapter
        }
    }
}
