package com.nadi.interviewprojecttest.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather")
    fun getAll(): Flow<List<WeatherEntity>>

    @Query("DELETE FROM weather")
    suspend fun deleteAll()

    @Query("SELECT * FROM weather WHERE id = :key ")
    suspend fun getSpecific(key: Long): WeatherEntity
}