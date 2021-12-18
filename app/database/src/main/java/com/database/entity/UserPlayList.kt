package com.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.database.DateConverter
import java.util.*


@Entity(tableName = "user_playlist")
data class UserPlayList(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_id")
    var movieId: Long = 0,

    @ColumnInfo(name = "playlist_id")
    var playListId: Int,

    @ColumnInfo(name = "created_at", defaultValue = "('Created at' || CURRENT_TIMESTAMP)")
    @TypeConverters(
        DateConverter::class
    )
    var createdAt: Date = Date(System.currentTimeMillis())
) {



}