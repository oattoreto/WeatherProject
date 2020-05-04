package com.example.weathermvvm

import android.app.Application
import com.example.weathermvvm.module.featureModule
import com.example.weathermvvm.module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(networkModule, featureModule))
        }
    }

}