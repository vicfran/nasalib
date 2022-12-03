package io.vicfran.lib

class NasaLib {

    private val nasaApi: NasaApi by lazy { NasaApi() }

    fun getAstronomyPictureOfTheDay(callback: (AstronomyPicture?) -> Unit) = nasaApi.getAstronomyPictureOfTheDay(callback)

}