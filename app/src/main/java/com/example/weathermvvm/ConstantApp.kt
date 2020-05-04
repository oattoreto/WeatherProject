package com.example.weathermvvm

class ConstantApp {

    companion object {
        const val baseURL = "https://api.openweathermap.org/"
        fun imageURL(iconName: String?): String =
            "http://openweathermap.org/img/wn/$iconName@2x.png"

        const val appId = "9a0ddeac0a7c1156bc52d2f1e0e5672e"
        const val dateFormat = "dd/MM/yyyy HH:mm"

        const val unitCelsius  = "metric"
        const val unitFahrenheit = "imperial"

        const val keyUnit = "extra_unit"
        const val keyCurrentWeather = "extra_weather"
    }

}