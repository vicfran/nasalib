package io.vicfran.nasalib.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.vicfran.nasalib.AstronomyPicture

@Database(
    entities = [AstronomyPicture::class],
    version = 1
)
abstract class NasaDatabase : RoomDatabase() {
    abstract fun astronomyPictureDao(): AstronomyPictureDao

    companion object {
        private var instance: NasaDatabase? = null

        fun getInstance(context: Context): NasaDatabase {
            return instance ?: Room
                .databaseBuilder(context, NasaDatabase::class.java, "NasaLibDatabase")
                .build()
                .also { instance = it }
        }
    }

}