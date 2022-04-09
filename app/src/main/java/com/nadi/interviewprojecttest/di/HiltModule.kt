package com.nadi.interviewprojecttest.di

import android.app.Application
import androidx.room.Room
import com.nadi.interviewprojecttest.data.WeatherDB
import com.nadi.interviewprojecttest.service.api.WeatherApi
import com.nadi.interviewprojecttest.ui.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideDB(app: Application): WeatherDB =
        Room.databaseBuilder(app, WeatherDB::class.java, "weather_db")
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(WeatherApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi =
        retrofit.create(WeatherApi::class.java)

}