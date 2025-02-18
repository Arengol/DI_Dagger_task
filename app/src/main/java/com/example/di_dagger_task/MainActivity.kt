package com.example.di_dagger_task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.di_dagger_task.DI.createActivityComponent
import com.example.di_dagger_task.app.MyApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createActivityComponent((application as MyApplication).appComponent).inject(this)
        presenter.performAction()
    }
}