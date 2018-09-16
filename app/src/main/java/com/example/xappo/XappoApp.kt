package com.example.xappo

import android.app.Application
import com.example.xappo.di.*

class XappoApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .presenterModule(PresenterModule())
                .build()

        // if we want to inject objects into this class uncomment this
        //appComponent.inject(this)
    }
}