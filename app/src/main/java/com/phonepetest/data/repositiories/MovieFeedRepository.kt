package com.phonepetest.data.repositiories

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import com.genericresponse.NetworkResponse
import com.phonepetest.data.response.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieFeedRepository {
    fun getMovieFeeds(page: Int): Flow<NetworkResponse<MovieResponse>>
}