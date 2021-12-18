package com.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.database.dao.UserPlayListDao
import com.database.entity.PlayList
import com.database.entity.UserPlayList
import java.util.*


@Database(
    entities = [PlayList::class, UserPlayList::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class SplitWiseDatabase : RoomDatabase() {
    abstract fun getPlayListDao(): UserPlayListDao

}

object DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long): Date {
        return Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date): Long {
        return date.time
    }
}


