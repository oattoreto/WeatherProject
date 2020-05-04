package com.example.weathermvvm.page.forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermvvm.ConstantApp
import com.example.weathermvvm.model.CurrentWeatherModel
import com.example.weathermvvm.model.ForecastWeatherModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response

class ForecastWeatherViewModel(private val repository: ForecastWeatherRepository) : ViewModel() {

    private var currentWeather = MutableLiveData<CurrentWeatherModel>()
    private var forecastWeather = MutableLiveData<ForecastWeatherModel>()
    private var error = MutableLiveData<String>()

    fun getCurrentWeather(): LiveData<CurrentWeatherModel> {
        return currentWeather
    }

    fun getForecastWeather(): LiveData<ForecastWeatherModel> {
        return forecastWeather
    }

    fun loadService(item: CurrentWeatherModel?, unit: String?) {
        currentWeather.value = item

        currentWeather.value?.let {
            viewModelScope.launch {
                val data = async {
                    repository.getForecastWeather(
                        it.coord.lat,
                        it.coord.lon,
                        unit ?: ConstantApp.unitCelsius
                    )
                }.await()
                if (data.isSuccessful) {
                    success(data)
                } else {
                    failure(data)
                }
            }
        }
    }

    private fun success(data: Response<ForecastWeatherModel>) {
        forecastWeather.value = data.body()
        error.value = null
    }

    private fun failure(data: Response<ForecastWeatherModel>) {
        forecastWeather.value = null
        error.value = data.message()
    }

}