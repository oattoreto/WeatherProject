package com.example.weathermvvm.page.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weathermvvm.ConstantApp
import com.example.weathermvvm.databinding.ActivityMainBinding
import com.example.weathermvvm.page.forecast.ForecastActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: CurrentWeatherViewModel by viewModel()

    private fun initBinding() {
        binding.vm = viewModel
        binding.page = this
        binding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBinding()
    }

    fun intentForecast() {
        startActivity(Intent(this, ForecastActivity::class.java).apply {
            putExtras(Bundle().apply {
                putString(ConstantApp.keyUnit, viewModel.units.get())
                putParcelable(ConstantApp.keyCurrentWeather, viewModel.getCurrentWeather().value)
            })
        })
    }
}
