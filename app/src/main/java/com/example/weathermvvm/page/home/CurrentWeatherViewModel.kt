package com.example.weathermvvm.page.home

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermvvm.ConstantApp
import com.example.weathermvvm.model.CurrentWeatherModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response

class CurrentWeatherViewModel(private val repository: CurrentWeatherRepository) : ViewModel() {

    private var currentWeather = MutableLiveData<CurrentWeatherModel>()
    private var error = MutableLiveData<String>()
    val searchCity = ObservableField<String>()
    val units = ObservableField<String>()

    fun getCurrentWeather(): LiveData<CurrentWeatherModel> {
        return currentWeather
    }

    fun getError(): LiveData<String> = error

    fun loadService() {
        viewModelScope.launch {
            val data = async {
                repository.getCurrentWeather(
                    searchCity.get() ?: "",
                    units.get() ?: ConstantApp.unitCelsius
                )
            }.await()
            if (data.isSuccessful) {
                success(data)
            } else {
                failure(data)
            }
        }
    }

    private fun success(data: Response<CurrentWeatherModel>) {
        currentWeather.value = data.body()
        error.value = null
    }

    private fun failure(data: Response<CurrentWeatherModel>) {
        currentWeather.value = null
        error.value = data.message()
    }

    fun setMetricCelsius() {
        if (units.get() != ConstantApp.unitCelsius) {
            units.set(ConstantApp.unitCelsius)
            loadService()
        }
    }

    fun setMetricFahrenheit() {
        if (units.get() != ConstantApp.unitFahrenheit) {
            units.set(ConstantApp.unitFahrenheit)
            loadService()
        }
    }

}