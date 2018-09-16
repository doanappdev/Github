package com.example.xappo.di

import com.example.xappo.repository.GithubRepository
import com.example.xappo.ui.main.MainContract
import com.example.xappo.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @[Provides Singleton]
    fun provideMainPresenter(repository: GithubRepository) : MainContract.Presenter = MainPresenter(repository)
}