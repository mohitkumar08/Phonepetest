package com.phonepetest.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genericresponse.CommState
import com.genericresponse.NetworkResponse
import com.phonepetest.data.repositiories.MovieFeedRepository
import com.phonepetest.data.response.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

class FeedViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: MovieFeedRepository

    private val _movieFeedFlow = MutableSharedFlow<CommState<List<MovieModel>>>()
    val movieFeedFlow: SharedFlow<CommState<List<MovieModel>>> = _movieFeedFlow
    private var pageNumber = 1
    private var totalPage = 0

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMovieFeeds(pageNumber).collectLatest { data ->
                when (data) {
                    is NetworkResponse.Init -> {
                        _movieFeedFlow.emit(CommState.Loading())
                    }
                    is NetworkResponse.Success -> {
                        pageNumber = data.body.page + 1
                        if (totalPage == 0) {
                            totalPage = data.body.totalPages
                        }
                        _movieFeedFlow.emit(CommState.Success(data.body.movieList))
                    }
                    else -> {
                        _movieFeedFlow.emit(CommState.Error())
                    }
                }
            }
        }
    }
}