package com.example.xappo.di

import com.example.xappo.service.GithubService
import com.example.xappo.repository.GithubRepository
import com.example.xappo.repository.GithubRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @[Provides Singleton]
    fun provideGithub(service: GithubService) : GithubRepository = GithubRepositoryImpl(service)
}