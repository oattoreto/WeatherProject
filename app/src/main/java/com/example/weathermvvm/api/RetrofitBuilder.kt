package com.example.weathermvvm.api

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit

class RetrofitBuilder(
    val okHttpClient: OkHttpClient,
    val converterFactory: Converter.Factory,
    val adapterFactory: CallAdapter.Factory
) {

    inline fun <reified T> build(baseUrl: String): T {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()
            .create(T::class.java)
    }
}