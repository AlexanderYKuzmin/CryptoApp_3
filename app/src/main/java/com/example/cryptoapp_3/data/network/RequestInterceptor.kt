package com.example.cryptoapp_3.data.network

import okhttp3.Interceptor
import okhttp3.Response

object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("Outgoing request to: ${request.url()}")
        return chain.proceed(request)
    }
}