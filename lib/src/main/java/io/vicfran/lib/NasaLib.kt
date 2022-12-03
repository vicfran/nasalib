package io.vicfran.lib

class NasaLib {

    private val nasaRepository: NasaRepository by lazy { NasaRepository(NasaApi()) }

    fun getAstronomyPictureOfTheDay(callback: (AstronomyPicture?) -> Unit) = nasaRepository.getAstronomyPictureOfTheDay(callback)

}