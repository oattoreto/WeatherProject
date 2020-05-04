package com.example.weathermvvm.page.home

import com.example.weathermvvm.model.CurrentWeatherModel
import com.example.weathermvvm.model.ForecastWeatherModel
import retrofit2.Response


interface CurrentWeatherRepository {

    suspend fun getCurrentWeather(city: String, units: String): Response<CurrentWeatherModel>

}