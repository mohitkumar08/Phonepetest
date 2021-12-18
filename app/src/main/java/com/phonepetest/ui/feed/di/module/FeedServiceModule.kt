package com.phonepetest.ui.feed.di.module

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import com.kootest.di.scope.AppMainScope
import com.phonepetest.data.service.MovieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object FeedServiceModule {

    @AppMainScope
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

}