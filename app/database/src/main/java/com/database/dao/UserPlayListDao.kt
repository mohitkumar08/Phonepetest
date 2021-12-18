package com.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.database.entity.UserPlayList

@Dao
interface UserPlayListDao {
    @Insert
    fun addPlayList(userPlayList: UserPlayList): Long

}