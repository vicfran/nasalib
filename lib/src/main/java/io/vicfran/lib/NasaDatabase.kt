package io.vicfran.lib

class NasaDatabase {

    private var astronomyPictureOfTheDay: AstronomyPicture? = null

    fun getAstronomyPictureOfTheDay(): AstronomyPicture? {
        return astronomyPictureOfTheDay
    }

    fun storeAstronomyPictureOfTheDay(astronomyPicture: AstronomyPicture) {
        this.astronomyPictureOfTheDay = astronomyPicture
    }

}