package io.vicfran.nasalib.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "astronomy_picture"
)
data class AstronomyPicture(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "date") val date: String = "",
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "explanation") val explanation: String = "",
    @ColumnInfo(name = "url") val hdUrl: String = ""
)
