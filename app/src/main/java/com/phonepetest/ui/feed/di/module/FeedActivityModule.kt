package com.phonepetest.ui.feed.di.module

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.kootest.di.scope.AppMainScope
import com.phonepetest.ui.feed.adapter.FeedAdapter
import dagger.Module
import dagger.Provides

@Module
object FeedActivityModule {

    @AppMainScope
    @Provides
    fun provideLinearLayout(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @AppMainScope
    @Provides
    fun provideFeedAdapter(): FeedAdapter = FeedAdapter()
}