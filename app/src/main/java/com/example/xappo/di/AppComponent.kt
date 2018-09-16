package com.example.xappo.di

import com.example.xappo.ui.MainActivity
import com.example.xappo.XappoApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    PresenterModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: XappoApp) : Builder
        fun appModule(appModule: AppModule) : Builder
        fun networkModule(networkModule: NetworkModule) : Builder
        fun repositoryModule(repositoryModule: RepositoryModule) : Builder
        fun presenterModule(presenterModule: PresenterModule) : Builder
        fun build() : AppComponent
    }

    fun inject(mainActivity: MainActivity)
}