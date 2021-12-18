package com.core

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @created 18/12/21}
 * @author Mohit Kumar
 *
 */
class ApiInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val request: Request = chain.request()
            .newBuilder()
            .url(url)
            .build();
        val response = chain.proceed(request);
        return response;
    }
}