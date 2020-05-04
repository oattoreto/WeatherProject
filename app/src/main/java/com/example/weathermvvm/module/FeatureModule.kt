package com.example.weathermvvm.module

import com.example.weathermvvm.page.forecast.ForecastWeatherRepository
import com.example.weathermvvm.page.forecast.ForecastWeatherRepositoryImpl
import com.example.weathermvvm.page.forecast.ForecastWeatherViewModel
import com.example.weathermvvm.page.home.CurrentWeatherRepository
import com.example.weathermvvm.page.home.CurrentWeatherRepositoryImpl
import com.example.weathermvvm.page.home.CurrentWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    factory<CurrentWeatherRepository> { CurrentWeatherRepositoryImpl(get()) }
    factory<ForecastWeatherRepository> { ForecastWeatherRepositoryImpl(get()) }

    viewModel { CurrentWeatherViewModel(get()) }
    viewModel { ForecastWeatherViewModel(get()) }
}