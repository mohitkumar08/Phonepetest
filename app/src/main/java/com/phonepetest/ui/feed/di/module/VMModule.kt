package com.phonepetest.ui.feed.di.module

import androidx.lifecycle.ViewModel
import com.phonepetest.ui.feed.FeedViewModel
import com.vmcore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

@Module
abstract class VMModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun userFeedViewModel(viewModel: FeedViewModel): ViewModel

}
