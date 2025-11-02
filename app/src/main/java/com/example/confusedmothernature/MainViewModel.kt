package com.example.confusedmothernature

import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confusedmothernature.models.Weather
import com.example.confusedmothernature.services.WeatherService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class Coordinates(val latitude: Double, val longitude: Double)

class MainViewModel: ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    //Retrofit instance
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //Initialize interface service
    val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    fun onLocationReceived(location: Location){
        val coords = Coordinates(location.latitude,location.longitude)
        //simple null check
        if(_weather.value == null){
            fetchWeatherForecast(coords)
        }
    }

    fun fetchWeatherForecast(coords: Coordinates){
        val locationQuery = "${coords.latitude},${coords.longitude}"

        viewModelScope.launch{
           try{
               val response: Weather = weatherService.getDailyForecast(
                   apiKey = "80107a14317f41ffb5d125048252110",
                   location = locationQuery,
                   days = 3,
                   aqi = "no"
               )
               _weather.value = response
           }catch(e: Exception){
               Log.e("WEATHER_API_ERROR", "Failed to fetch weather data: ${e.message}", e)
               _weather.value = null
           }
        }
    }
}