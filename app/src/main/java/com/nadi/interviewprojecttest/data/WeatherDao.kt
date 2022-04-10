package com.nadi.interviewprojecttest.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather")
    fun getAll(): LiveData<List<WeatherEntity>>?

    @Query("DELETE FROM weather")
    suspend fun deleteAll()


    @Query("SELECT * FROM weather WHERE id = :key ")
    suspend fun getSpecific(key: Long): WeatherEntity?
}