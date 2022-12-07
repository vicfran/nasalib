package io.vicfran.nasalib.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import io.vicfran.nasalib.data.AstronomyPicture

@Dao
interface AstronomyPictureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(astronomyPictureRoomEntities: List<AstronomyPicture>)

    @Delete
    fun delete(astronomyPicture: AstronomyPicture)

    @Query("SELECT * FROM astronomy_picture")
    fun getAstronomyPictures(): LiveData<AstronomyPicture>

    @Query("SELECT * FROM astronomy_picture WHERE id = :id")
    fun getAstronomyPicture(id: Long): LiveData<AstronomyPicture>

    @Query("SELECT * FROM astronomy_picture WHERE date = :date")
    fun getAstronomyPictureByDate(date: String): LiveData<AstronomyPicture>
}