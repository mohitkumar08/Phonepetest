package com.phonepetest.ui.feed.di

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import androidx.recyclerview.widget.LinearLayoutManager
import com.core.BaseComponent
import com.kootest.di.scope.AppMainScope
import com.phonepetest.ui.feed.di.module.FeedActivityModule
import com.phonepetest.ui.feed.di.module.RepositoryModule
import com.phonepetest.data.repositiories.MovieFeedRepository
import com.phonepetest.ui.feed.di.module.VMModule
import com.phonepetest.ui.feed.FeedActivity
import com.phonepetest.ui.feed.adapter.FeedAdapter
import com.phonepetest.ui.feed.di.module.FeedServiceModule
import com.vmcore.VMFactoryModule
import dagger.Component

@AppMainScope
@Component(
    modules = [VMFactoryModule::class,
        VMModule::class,
        FeedActivityModule::class,
        FeedServiceModule::class,
        RepositoryModule::class],
    dependencies = [BaseComponent::class]
)
interface MovieFeedsComponent {

    @Component.Builder
    interface Builder {
        fun dependBaseComponent(baseComponent: BaseComponent): Builder
        fun build(): MovieFeedsComponent
    }

    fun inject(mainActivity: FeedActivity)

    fun getUserFeedRepository(): MovieFeedRepository

    fun getFeedAdapter(): FeedAdapter

    fun getLinearLayoutManager(): LinearLayoutManager


}