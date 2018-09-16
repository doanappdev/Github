package com.example.xappo.di

import com.example.xappo.service.GithubService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    //val BASE_URL = "http://assure-ios-dev.s3.amazonaws.com/ios-tech-test-data-qantas-twitter.zip/"
    val BASE_URL = "https://api.github.com/"

    @[Provides Singleton]
    fun provideRetrofitBuilder() : Retrofit.Builder =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())

    @[Provides Singleton]
    fun provideTweetsService(builder: Retrofit.Builder) : GithubService {
        val httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()

        return builder.client(httpClient)
                .baseUrl(BASE_URL)
                .build()
                .create(GithubService::class.java)
    }
}