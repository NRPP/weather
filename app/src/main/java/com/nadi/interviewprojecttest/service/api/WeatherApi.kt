package com.nadi.interviewprojecttest.service.api

import com.nadi.interviewprojecttest.service.apiresponce.ResponseWeather
import retrofit2.http.Field
import retrofit2.http.GET

interface WeatherApi {

    companion object{

        const val apiKey = "95041ee3588442b59b8162345220804"
        val BASE_URL = "http://api.weatherapi.com/v1/forecast.json?key=${apiKey}"

    }

    @GET("&q=London&days=10")
    suspend fun getResponse(
//        @Field("q") name: String = "London",
//        @Field("days") days: Int = 10
    ):List<ResponseWeather>

}