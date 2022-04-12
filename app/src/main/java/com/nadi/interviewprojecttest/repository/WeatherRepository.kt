package com.nadi.interviewprojecttest.repository

import androidx.room.withTransaction
import com.nadi.interviewprojecttest.data.WeatherDB
import com.nadi.interviewprojecttest.service.api.WeatherApi
import com.nadi.interviewprojecttest.service.api.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val db: WeatherDB,
    private val api: WeatherApi
){
    private val dao = db.dao

    suspend fun getResponse()= networkBoundResource(
        query = {

            dao.getAll()
        },
        fetch = {

            api.getResponse()
                },
        saveFetchResult = { weather ->
            db.withTransaction {
                dao.deleteAll()
            }
        }
    )

}