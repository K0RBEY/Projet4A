package com.example.projet4a.Data.Remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url().newBuilder().addQueryParameter("APPID","812a501cb335503b7bcbf879dd8e5f98").build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}