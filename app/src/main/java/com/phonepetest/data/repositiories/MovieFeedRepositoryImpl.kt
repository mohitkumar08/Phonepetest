package com.phonepetest.data.repositiories

import com.genericresponse.NetworkResponse
import com.kootest.di.scope.AppMainScope
import com.phonepetest.data.response.MovieResponse
import com.phonepetest.data.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

@AppMainScope
class MovieFeedRepositoryImpl @Inject constructor(private val movieService: MovieService) :
    MovieFeedRepository {


    override fun getMovieFeeds(page: Int): Flow<NetworkResponse<MovieResponse>> = flow {
        try {
            emit(NetworkResponse.Init("InitApi"))
            val resp = movieService.getMovieFeed(page)
            emit(NetworkResponse.Success(resp))
        } catch (ex: Throwable) {
            ex.printStackTrace()
            emit(NetworkResponse.UnknownError(ex))
        }
    }
}