package com.example.weathermvvm.model


import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class CurrentWeatherModel(
    @SerializedName("base")
    var base: String = "",
    @SerializedName("clouds")
    var clouds: Clouds = Clouds(),
    @SerializedName("cod")
    var cod: Int = 0,
    @SerializedName("coord")
    var coord: Coord = Coord(),
    @SerializedName("dt")
    var dt: Long = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("main")
    var main: Main = Main(),
    @SerializedName("name")
    var name: String = "",
    @SerializedName("sys")
    var sys: Sys = Sys(),
    @SerializedName("visibility")
    var visibility: Int = 0,
    @SerializedName("weather")
    var weather: List<Weather> = listOf(),
    @SerializedName("wind")
    var wind: Wind = Wind()
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Clouds(
    @SerializedName("all")
    var all: Int = 0
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Coord(
    @SerializedName("lat")
    var lat: Double = 0.0,
    @SerializedName("lon")
    var lon: Double = 0.0
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Main(
    @SerializedName("humidity")
    var humidity: Int = 0,
    @SerializedName("pressure")
    var pressure: Int = 0,
    @SerializedName("temp")
    var temp: Double = 0.0,
    @SerializedName("temp_max")
    var tempMax: Double = 0.0,
    @SerializedName("temp_min")
    var tempMin: Double = 0.0,
    @SerializedName("feels_like")
    var feels_like: Double = 0.0
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Sys(
    @SerializedName("country")
    var country: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("message")
    var message: Double = 0.0,
    @SerializedName("sunrise")
    var sunrise: Long = 0,
    @SerializedName("sunset")
    var sunset: Long = 0,
    @SerializedName("type")
    var type: Int = 0
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Wind(
    @SerializedName("deg")
    var deg: Int = 0,
    @SerializedName("speed")
    var speed: Double = 0.0
) : Parcelable