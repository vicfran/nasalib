package io.vicfran.lib.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "astronomy_picture"
)
data class AstronomyPictureRoomEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "date") val date: String = "",
    @ColumnInfo(name = "explanation") val explanation: String = "",
    @ColumnInfo(name = "hd_url") val hdUrl: String = "",
    @ColumnInfo(name = "media_type") val mediaType: String = "",
    @ColumnInfo(name = "service_version") val serviceVersion: String = "",
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "url") val url: String = ""
)