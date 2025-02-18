package com.example.di_dagger_task.DI

import android.app.Application
import com.example.di_dagger_task.MainActivity
import com.example.di_dagger_task.MainPresenter
import com.example.di_dagger_task.PresenterInterface
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Component(modules = [AppModule::class, ActivityModule::class])
interface AppComponent {
    fun activityComponent(): ActivityComponent.Factory
}

@Module
class AppModule(private val application: Application) {
    @Provides
    fun provideApplication(): Application {
        return application
    }
}

@Subcomponent
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: MainActivity)
}

@Module(subcomponents = [ActivityComponent::class])
class ActivityModule {
    @Provides
    fun providePresenter(application: Application): PresenterInterface {
        return MainPresenter(application)
    }
}

fun createAppComponent(application: Application) = DaggerAppComponent.builder()
    .appModule(AppModule(application))
    .build()

fun createActivityComponent(appComponent: AppComponent) = appComponent.activityComponent().create()