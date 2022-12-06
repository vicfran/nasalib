package io.vicfran.lib

import io.vicfran.lib.persistence.NasaDatabase

internal class NasaRepository(private val nasaApi: NasaApi, private val database: NasaDatabase) {

    fun getAstronomyPictureOfTheDay(callback: (AstronomyPicture?) -> Unit) {
        return if (database.getAstronomyPictureOfTheDay() != null) callback(database.getAstronomyPictureOfTheDay())
        else {
            nasaApi.getAstronomyPictureOfTheDay {
                it?.let {
                    database.storeAstronomyPictureOfTheDay(it)
                }.apply {
                    callback(it)
                }
            }
        }
    }

}