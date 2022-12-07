package io.vicfran.nasalib

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.vicfran.nasalib.data.NasaRepository
import javax.inject.Inject

@HiltViewModel
class AstronomyPictureViewModel @Inject constructor(
    nasaRepository: NasaRepository
) : ViewModel() {
    val astronomyPictureOfTheDay = nasaRepository.getAstronomyPictureOfTheDay()
}