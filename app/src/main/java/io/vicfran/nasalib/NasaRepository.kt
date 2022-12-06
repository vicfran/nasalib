package io.vicfran.nasalib

import androidx.lifecycle.LiveData
import io.vicfran.nasalib.persistence.AstronomyPictureDao
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class NasaRepository @Inject constructor(
    private val astronomyPictureDao: AstronomyPictureDao
) {

    fun getAstronomyPictureOfTheDay(): LiveData<AstronomyPicture> {
        val today = SimpleDateFormat("yyyy-MM-DD", Locale.getDefault()).format(Date())
        return astronomyPictureDao.getAstronomyPictureByDate(today)
    }

}