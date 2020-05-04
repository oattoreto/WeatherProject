package com.example.weathermvvm.module

import com.example.weathermvvm.ConstantApp
import com.example.weathermvvm.api.Api
import com.example.weathermvvm.api.OkHttpBuilder
import com.example.weathermvvm.api.RetrofitBuilder
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { OkHttpBuilder(get()).build() }

    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single { RetrofitBuilder(get(), get(), get()) }

    single<Api> { get<RetrofitBuilder>().build(ConstantApp.baseURL) }
}