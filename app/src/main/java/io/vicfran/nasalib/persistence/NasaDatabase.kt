package io.vicfran.nasalib.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import io.vicfran.nasalib.data.AstronomyPicture
import java.util.concurrent.Executors

@Database(
    entities = [AstronomyPicture::class],
    version = 1
)
abstract class NasaDatabase : RoomDatabase() {
    abstract fun astronomyPictureDao(): AstronomyPictureDao

    companion object {
        private const val databaseName = "NasaLibDatabase"

        @Volatile
        private var instance: NasaDatabase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context): NasaDatabase {
            return Room.databaseBuilder(context, NasaDatabase::class.java, databaseName)
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            getInstance(context).astronomyPictureDao().insertAll(
                                listOf(
                                    AstronomyPicture(
                                        date = "2022-12-06",
                                        title = "M16: A Star Forming Pillar from Webb",
                                        explanation = "What\\u2019s happening inside this interstellar mountain? Stars are forming. The mountain is actually a column of gas and dust in the picturesque Eagle Nebula (M16). A pillar like this is so low in density that you could easily fly though it -- it only appears solid because of its high dust content and great depth. The glowing areas are lit internally by newly formed stars. These areas shine in red and infrared light because blue light is scattered away by intervening interstellar dust. The featured image was captured recently in near-infrared light in unprecedented detail by the James Webb Space Telescope (JWST), launched late last year. Energetic light, abrasive winds, and final supernovas from these young stars will slowly destroy this stellar birth column over the next 100,000 years. Astrophysicists: Browse 2,900+ codes in the Astrophysics Source Code Library",
                                        hdUrl = "https://apod.nasa.gov/apod/image/2212/M16Pillar_WebbOzsarac_1668.jpg"
                                    ),
                                    AstronomyPicture(
                                        date = "2022-12-07",
                                        title = "NGC 7293: The Helix Nebula",
                                        explanation = "A mere seven hundred light years from Earth, toward the constellation Aquarius, a sun-like star is dying. The dying star's last few thousand years have produced the Helix Nebula (NGC 7293), a well studied and nearby example of a Planetary Nebula, typical of this final phase of stellar evolution. Combining narrow band image data from emission lines of hydrogen atoms in red and oxygen atoms in blue-green hues, it shows tantalizing details of the Helix, including its bright inner region about 3 light-years across. The white dot at the Helix's center is this Planetary Nebula's hot, central star. A simple looking nebula at first glance, the Helix is now understood to have a surprisingly complex geometry.",
                                        hdUrl = "https://apod.nasa.gov/apod/image/2212/NGC7293-TommasoStella2022WEB.jpg"
                                    )
                                )
                            )
                        }
                    }
                }
                )
                .build()
        }
    }

}