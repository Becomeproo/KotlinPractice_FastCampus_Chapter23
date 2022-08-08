package com.example.practicekotlin23

import android.app.Application
import com.example.practicekotlin23.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PracticeKotlin23Application : Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO Koin Trigger
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PracticeKotlin23Application)
            modules(appModule)
        }

    }
}