package io.vicfran.lib.persistence

import io.vicfran.lib.AstronomyPicture

class NasaDatabase {

    private var astronomyPictureOfTheDay: AstronomyPicture? = null

    fun getAstronomyPictureOfTheDay(): AstronomyPicture? {
        return astronomyPictureOfTheDay
    }

    fun storeAstronomyPictureOfTheDay(astronomyPicture: AstronomyPicture) {
        this.astronomyPictureOfTheDay = astronomyPicture
    }

}