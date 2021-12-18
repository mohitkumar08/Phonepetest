package com.database

import com.database.dao.UserPlayListDao
import com.database.entity.UserPlayList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


 internal class ExpenseRepositoryImpl @Inject constructor(val playListDao: UserPlayListDao):ExpenseRepository {
     override fun savePlayList() {
         TODO("Not yet implemented")
     }

     override fun getAllPlayList(): Flow<List<UserPlayList>> {
         TODO("Not yet implemented")
     }

 }

interface ExpenseRepository  {
    fun savePlayList()

    fun getAllPlayList(): Flow<List<UserPlayList>>
}