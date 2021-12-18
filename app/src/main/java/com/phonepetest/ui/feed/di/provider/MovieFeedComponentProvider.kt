package com.phonepetest.ui.feed.di.provider

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */

import com.phonepetest.ui.feed.di.MovieFeedsComponent

interface MovieFeedComponentProvider {
    fun provideUserFeedsComponent(): MovieFeedsComponent
}