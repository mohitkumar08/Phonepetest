package com.database

import android.app.Application
import com.database.dao.UserPlayListDao
import com.database.di.DbModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DbModule::class])
interface DBComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): DBComponent
    }

    fun requireSplitWiseDatabase(): SplitWiseDatabase

    fun requireExpenseDao(): UserPlayListDao

    fun requireExpenseRepository():ExpenseRepository

}
