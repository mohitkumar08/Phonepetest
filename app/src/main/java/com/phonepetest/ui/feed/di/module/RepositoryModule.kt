package com.phonepetest.ui.feed.di.module

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import com.kootest.di.scope.AppMainScope
import com.phonepetest.data.repositiories.MovieFeedRepository
import com.phonepetest.data.repositiories.MovieFeedRepositoryImpl
import com.phonepetest.data.service.MovieService
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @AppMainScope
    @Provides
    fun provideMovieService(movieService: MovieService): MovieFeedRepository {
        return MovieFeedRepositoryImpl(movieService)
    }
}