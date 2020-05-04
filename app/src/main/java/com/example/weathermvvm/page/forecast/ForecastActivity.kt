package com.example.weathermvvm.page.forecast

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.weathermvvm.ConstantApp
import com.example.weathermvvm.R
import com.example.weathermvvm.databinding.ActivityForecastBinding
import com.example.weathermvvm.model.CurrentWeatherModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ForecastActivity : AppCompatActivity() {

    private val binding: ActivityForecastBinding by lazy {
        ActivityForecastBinding.inflate(
            layoutInflater
        )
    }
    private val viewModel: ForecastWeatherViewModel by viewModel()
    private val currentWeather: CurrentWeatherModel? by lazy {
        intent.extras?.getParcelable<CurrentWeatherModel>(
            ConstantApp.keyCurrentWeather
        )
    }
    private val unit: String? by lazy { intent.extras?.getString(ConstantApp.keyUnit) }
    private val adapter: ForecastAdapter by lazy { ForecastAdapter() }

    private fun initBinding() {
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    private fun initActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setTitle(R.string.home_button_forecast)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBinding()
        initActionBar()

        bind()
    }

    private fun bind() {
        viewModel.getForecastWeather().observe(this, Observer {
            binding.recyclerView.adapter = adapter
            adapter.submitList(it.hourly)
        })

        viewModel.loadService(currentWeather, unit)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}