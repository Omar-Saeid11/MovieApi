package com.example.movieapiwithcoroutineandnavcomponent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.movieapiwithcoroutineandnavcomponent.databinding.FragmentDetailsBinding
import com.example.movieapiwithcoroutineandnavcomponent.util.loadImageWithPlaceholderAndCrossFade


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    val args: DetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.item = args.movieResult
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieResult = DetailsFragmentArgs.fromBundle(requireArguments()).movieResult
        val posterPath = movieResult.posterPath

        if (posterPath != null) {
            val imageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"
            binding.imgProfile.loadImageWithPlaceholderAndCrossFade(imageUrl)
        }
    }
}