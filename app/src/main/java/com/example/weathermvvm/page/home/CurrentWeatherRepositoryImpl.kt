package com.example.weathermvvm.page.home

import com.example.weathermvvm.api.Api
import com.example.weathermvvm.model.CurrentWeatherModel
import com.example.weathermvvm.model.ForecastWeatherModel
import retrofit2.Response

class CurrentWeatherRepositoryImpl(private val api: Api) : CurrentWeatherRepository {

    override suspend fun getCurrentWeather(
        city: String,
        units: String
    ): Response<CurrentWeatherModel> {
        return api.getCurrentWeather(city, units)
    }
}