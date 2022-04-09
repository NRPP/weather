package com.nadi.interviewprojecttest.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDB : RoomDatabase() {

    abstract val dao: WeatherDao

}