package com.example.architecturecomponentkotlin

import android.app.Application
import com.example.architecturecomponentkotlin.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        androidContext(this@App)
        modules(appComponent)
    }
}