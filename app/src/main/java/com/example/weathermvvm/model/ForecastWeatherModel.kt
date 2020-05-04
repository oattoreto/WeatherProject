package com.example.weathermvvm.model


import com.google.gson.annotations.SerializedName

data class ForecastWeatherModel(
    @SerializedName("current")
    var current: Current = Current(),
    @SerializedName("daily")
    var daily: ArrayList<Daily> = ArrayList(),
    @SerializedName("hourly")
    var hourly: ArrayList<Hourly> = ArrayList(),
    @SerializedName("lat")
    var lat: Double = 0.0,
    @SerializedName("lon")
    var lon: Double = 0.0,
    @SerializedName("timezone")
    var timezone: String = ""
)

data class Current(
    @SerializedName("clouds")
    var clouds: Int = 0,
    @SerializedName("dew_point")
    var dewPoint: Double = 0.0,
    @SerializedName("dt")
    var dt: Int = 0,
    @SerializedName("feels_like")
    var feelsLike: Double = 0.0,
    @SerializedName("humidity")
    var humidity: Int = 0,
    @SerializedName("pressure")
    var pressure: Int = 0,
    @SerializedName("sunrise")
    var sunrise: Int = 0,
    @SerializedName("sunset")
    var sunset: Int = 0,
    @SerializedName("temp")
    var temp: Double = 0.0,
    @SerializedName("uvi")
    var uvi: Double = 0.0,
    @SerializedName("weather")
    var weather: List<Weather> = listOf(),
    @SerializedName("wind_deg")
    var windDeg: Int = 0,
    @SerializedName("wind_speed")
    var windSpeed: Double = 0.0
)

data class Daily(
    @SerializedName("clouds")
    var clouds: Int = 0,
    @SerializedName("dew_point")
    var dewPoint: Double = 0.0,
    @SerializedName("dt")
    var dt: Int = 0,
    @SerializedName("feels_like")
    var feelsLike: FeelsLike = FeelsLike(),
    @SerializedName("humidity")
    var humidity: Int = 0,
    @SerializedName("pressure")
    var pressure: Int = 0,
    @SerializedName("rain")
    var rain: Double = 0.0,
    @SerializedName("sunrise")
    var sunrise: Int = 0,
    @SerializedName("sunset")
    var sunset: Int = 0,
    @SerializedName("temp")
    var temp: Temp = Temp(),
    @SerializedName("uvi")
    var uvi: Double = 0.0,
    @SerializedName("weather")
    var weather: List<Weather> = listOf(),
    @SerializedName("wind_deg")
    var windDeg: Int = 0,
    @SerializedName("wind_speed")
    var windSpeed: Double = 0.0
)

data class FeelsLike(
    @SerializedName("day")
    var day: Double = 0.0,
    @SerializedName("eve")
    var eve: Double = 0.0,
    @SerializedName("morn")
    var morn: Double = 0.0,
    @SerializedName("night")
    var night: Double = 0.0
)

data class Hourly(
    @SerializedName("clouds")
    var clouds: Int = 0,
    @SerializedName("dew_point")
    var dewPoint: Double = 0.0,
    @SerializedName("dt")
    var dt: Long = 0,
    @SerializedName("feels_like")
    var feelsLike: Double = 0.0,
    @SerializedName("humidity")
    var humidity: Int = 0,
    @SerializedName("pressure")
    var pressure: Int = 0,
    @SerializedName("temp")
    var temp: Double = 0.0,
    @SerializedName("weather")
    var weather: List<Weather> = listOf(),
    @SerializedName("wind_deg")
    var windDeg: Int = 0,
    @SerializedName("wind_speed")
    var windSpeed: Double = 0.0
)

data class Temp(
    @SerializedName("day")
    var day: Double = 0.0,
    @SerializedName("eve")
    var eve: Double = 0.0,
    @SerializedName("max")
    var max: Double = 0.0,
    @SerializedName("min")
    var min: Double = 0.0,
    @SerializedName("morn")
    var morn: Double = 0.0,
    @SerializedName("night")
    var night: Double = 0.0
)