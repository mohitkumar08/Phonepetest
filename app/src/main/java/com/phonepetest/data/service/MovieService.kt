package com.phonepetest.data.service

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import com.kootest.di.scope.AppMainScope
import com.phonepetest.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

@AppMainScope
interface MovieService {

    @GET("movie/now_playing/")
    suspend fun getMovieFeed(@Query("page") pageNumber: Int): MovieResponse

}