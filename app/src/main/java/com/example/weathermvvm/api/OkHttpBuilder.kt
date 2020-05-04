package com.example.weathermvvm.api

import android.content.Context
import com.example.weathermvvm.utils.isConnected
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpBuilder(private val context: Context) {

    val cacheSize = (5 * 1024 * 1024).toLong()
    val myCache = Cache(context.cacheDir, cacheSize)

    fun build(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor { chain ->
            var request = chain.request()
            request = if (context.isConnected())
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header(
                    "Cache-Control",
                    "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                ).build()

            chain.proceed(request)
        }
        client.cache(myCache)
        return client
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .build()
    }

}