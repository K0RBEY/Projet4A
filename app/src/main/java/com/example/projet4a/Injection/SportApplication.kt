package com.example.projet4a.Injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SportApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@SportApplication)
            modules(presentationModule, domainModule, dataModule)

        }
    }
}