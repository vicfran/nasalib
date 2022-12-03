package io.vicfran.lib

internal class NasaRepository(private val nasaApi: NasaApi) {

    fun getAstronomyPictureOfTheDay(callback: (AstronomyPicture?) -> Unit) = nasaApi.getAstronomyPictureOfTheDay(callback)

}