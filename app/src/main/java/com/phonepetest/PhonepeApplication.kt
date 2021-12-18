package com.phonepetest

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */


import android.app.Application
import com.core.BaseComponent
import com.core.DaggerBaseComponent
import com.core.di.CoreComponentProvider
import com.core.di.module.AppModule
import com.phonepetest.ui.feed.di.DaggerMovieFeedsComponent
import com.phonepetest.ui.feed.di.MovieFeedsComponent
import com.phonepetest.ui.feed.di.provider.MovieFeedComponentProvider

class PhonepeApplication : Application(),CoreComponentProvider, MovieFeedComponentProvider {

    private val baseComponent by lazy {
        DaggerBaseComponent.builder().appModule(AppModule(this)).build()
    }

   override fun provideBaseComponent(): BaseComponent {
        return baseComponent
    }

    override fun provideUserFeedsComponent(): MovieFeedsComponent {
       return DaggerMovieFeedsComponent.builder().dependBaseComponent(provideBaseComponent()).build()
    }

}