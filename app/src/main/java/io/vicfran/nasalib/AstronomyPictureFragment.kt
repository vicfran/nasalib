package io.vicfran.nasalib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.vicfran.nasalib.databinding.FragmentAstronomyPictureBinding

@AndroidEntryPoint
class AstronomyPictureFragment : Fragment() {

    private lateinit var binding: FragmentAstronomyPictureBinding

    private val viewModel: AstronomyPictureViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAstronomyPictureBinding.inflate(inflater, container, false)

        viewModel.astronomyPictureOfTheDay.observe(viewLifecycleOwner) {
            val trash = it
        }

        return binding.root
    }

}