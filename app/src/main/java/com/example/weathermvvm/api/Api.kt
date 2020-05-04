package com.example.weathermvvm.api

import com.example.weathermvvm.ConstantApp
import com.example.weathermvvm.model.CurrentWeatherModel
import com.example.weathermvvm.model.ForecastWeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") appId: String = ConstantApp.appId
    ): Response<CurrentWeatherModel>


    @GET("data/2.5/onecall")
    suspend fun getForecastWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") appId: String = ConstantApp.appId
    ): Response<ForecastWeatherModel>

}