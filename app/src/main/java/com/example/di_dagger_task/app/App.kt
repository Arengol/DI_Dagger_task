package com.example.di_dagger_task.app


import android.app.Application
import com.example.di_dagger_task.DI.AppComponent
import com.example.di_dagger_task.DI.createAppComponent

class MyApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent(this)
    }
}