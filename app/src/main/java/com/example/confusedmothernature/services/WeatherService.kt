package com.example.confusedmothernature.services

import com.example.confusedmothernature.models.Weather
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    //Function for getting 3-day forecast, should trigger after location obtained
    //API key: 80107a14317f41ffb5d125048252110
    @GET("forecast.json")
    suspend fun getDailyForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 3,
        @Query("aqi") aqi: String = "no"
        ): Weather
}