package com.example.weathermvvm.page.forecast

import com.example.weathermvvm.model.CurrentWeatherModel
import com.example.weathermvvm.model.ForecastWeatherModel
import retrofit2.Response


interface ForecastWeatherRepository {

    suspend fun getForecastWeather(
        lat: Double,
        lon: Double,
        units: String
    ): Response<ForecastWeatherModel>

}