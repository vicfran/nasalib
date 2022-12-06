package io.vicfran.nasalib

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AstronomyPictureViewModel @Inject constructor(
    nasaRepository: NasaRepository
) : ViewModel() {
    val astronomyPictureOfTheDay = nasaRepository.getAstronomyPictureOfTheDay()

    class AstronomyPictureViewModelFactory(private val nasaRepository: NasaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AstronomyPictureViewModel(nasaRepository) as T
        }
    }
}