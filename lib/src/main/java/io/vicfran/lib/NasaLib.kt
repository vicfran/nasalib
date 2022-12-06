package io.vicfran.lib

import io.vicfran.lib.persistence.NasaDatabase

class NasaLib {

    private val nasaRepository: NasaRepository by lazy { NasaRepository(NasaApi(), NasaDatabase()) }

    fun getAstronomyPictureOfTheDay(callback: (AstronomyPicture?) -> Unit) = nasaRepository.getAstronomyPictureOfTheDay(callback)

}