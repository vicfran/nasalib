package io.vicfran.nasalib.data

import androidx.lifecycle.LiveData
import io.vicfran.nasalib.persistence.AstronomyPictureDao
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class NasaRepository @Inject constructor(
    private val astronomyPictureDao: AstronomyPictureDao
) {

    fun getAstronomyPictureOfTheDay(): LiveData<AstronomyPicture> {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return astronomyPictureDao.getAstronomyPictureByDate(today)
    }

}