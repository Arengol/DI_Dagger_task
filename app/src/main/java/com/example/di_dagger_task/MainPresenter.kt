package com.example.di_dagger_task

import android.app.Application
import com.example.di_dagger_task.DI.ActivityScope
import javax.inject.Inject

interface PresenterInterface {
    fun performAction()
}
@ActivityScope
class MainPresenter @Inject constructor(private val application: Application) : PresenterInterface {

    override fun performAction() {
        println("Test")
    }
}


