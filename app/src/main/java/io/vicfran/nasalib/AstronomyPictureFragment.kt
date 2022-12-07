package io.vicfran.nasalib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import io.vicfran.nasalib.data.AstronomyPicture
import io.vicfran.nasalib.databinding.FragmentAstronomyPictureBinding

@AndroidEntryPoint
class AstronomyPictureFragment : Fragment() {

    private lateinit var binding: FragmentAstronomyPictureBinding

    private val viewModel: AstronomyPictureViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAstronomyPictureBinding.inflate(inflater, container, false)

        viewModel.astronomyPictureOfTheDay.observe(viewLifecycleOwner) {
            renderUi(it)
        }

        return binding.root
    }

    private fun renderUi(it: AstronomyPicture) {
        binding.tvTitle.text = it.title
        Picasso.get().load(it.hdUrl).into(binding.image)
        binding.tvExplanation.text = it.explanation
    }

}