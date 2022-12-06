package io.vicfran.lib.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AstronomyPictureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg astronomyPictureRoomEntity: AstronomyPictureRoomEntity)

    @Delete
    fun delete(astronomyPictureRoomEntity: AstronomyPictureRoomEntity)

    @Query("SELECT * FROM astronomy_picture")
    fun getAll(): List<AstronomyPictureRoomEntity>

}