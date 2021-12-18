package com.phonepetest.ui.feed

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.core.CoreActivity
import com.genericresponse.CommState
import com.phonepetest.R
import com.phonepetest.databinding.ActivityMainBinding
import com.phonepetest.ui.feed.adapter.FeedAdapter
import com.phonepetest.ui.feed.di.provider.MovieFeedComponentProvider
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class FeedActivity : CoreActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var feedAdapter: FeedAdapter

    private var isLoading = false
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewModel: FeedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.handler = this
        viewModel = ViewModelProvider(this, viewModelFactory)[FeedViewModel::class.java]
        initUI()
        addObservable()
        viewModel.getMovies()
    }

    override fun setupActivityComponent() {
        (applicationContext as MovieFeedComponentProvider)
            .provideUserFeedsComponent()
            .inject(this)
    }

    private fun initUI() {
        with(viewBinding.recyclerView) {
            viewBinding.recyclerView.layoutManager = linearLayoutManager
            adapter = feedAdapter

            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!isLoading) {
                        if (layoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (feedAdapter.itemCount - 1)) {
                            viewModel.getMovies()
                            isLoading = true
                        }
                    }
                }
            })
        }
    }

    private fun addObservable() {
        lifecycleScope.launchWhenCreated {
            viewModel.movieFeedFlow.collectLatest {
                when (it) {
                    is CommState.Loading -> {
                        showProgressView()
                    }
                    is CommState.Success -> {
                        hideProgressView()
                        feedAdapter.addItems(it.body)
                        isLoading = false
                        Toast.makeText(
                            context,
                            getText(R.string.new_feed),
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                    is CommState.Error -> {
                        hideProgressView()
                        isLoading = false
                        Toast.makeText(
                            context,
                            getText(R.string.generic_message_for_error),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    else -> {
                        hideProgressView()
                        isLoading = true
                    }
                }
            }
        }
    }

    private fun showProgressView() {
        viewBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressView() {
        viewBinding.progressBar.visibility = View.GONE
    }

}