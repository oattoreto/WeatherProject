package com.example.weathermvvm.page.forecast

import com.example.weathermvvm.api.Api
import com.example.weathermvvm.model.ForecastWeatherModel
import retrofit2.Response

class ForecastWeatherRepositoryImpl(private val api: Api) : ForecastWeatherRepository {

    override suspend fun getForecastWeather(
        lat: Double,
        lon: Double,
        units: String
    ): Response<ForecastWeatherModel> {
        return api.getForecastWeather(lat, lon, units)
    }
}