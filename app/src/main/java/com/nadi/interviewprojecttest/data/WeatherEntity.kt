package com.nadi.interviewprojecttest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(

    val name : String,
    val icon : String,
    val temp_c : Float,

    @PrimaryKey
    val id: Long = 0
)