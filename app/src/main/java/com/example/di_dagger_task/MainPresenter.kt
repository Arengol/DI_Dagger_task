package com.example.di_dagger_task

import android.app.Application
import javax.inject.Inject

interface PresenterInterface {
    fun performAction()
}

class MainPresenter @Inject constructor(private val application: Application) : PresenterInterface {

    override fun performAction() {
        println("Test")
    }
}


