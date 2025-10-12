package com.example.confusedmothernature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confusedmothernature.models.Current
import com.example.confusedmothernature.models.Forecast
import com.example.confusedmothernature.models.Weather
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    init {

        val current = Current(
            currentImage = R.drawable.rain_512,
            curCondition = "Rain",
            temperature = 10,
            feelLike = 12,
            precipitationPossibility = 100,
            precipitationType = "Heavy Rain",
            precipitationAmount = 13,
            curWindDir = "SSE",
            curWindSpeed = 24
        )

        viewModelScope.launch{
            delay(5000)
        }

        val forecast = listOf(
            Forecast(
                date = "Tue. Nov 25",
                forecastImage = R.drawable.snow,
                condition = "Snow",
                tempHigh = 3,
                tempLow = -10,
                precipitationType = "Light Snow",
                precipitationPossibility = 50,
                precipitationAmount = 3,
                windSpeed = 15,
                humidity = 20
            ),
            Forecast(
                date = "Wed. Nov 26",
                forecastImage = R.drawable.snow,
                condition = "Snow",
                tempHigh = 3,
                tempLow = -10,
                precipitationType = "Light Snow",
                precipitationPossibility = 50,
                precipitationAmount = 3,
                windSpeed = 15,
                humidity = 20
            ),
            Forecast(
                date = "Thu. Nov 27",
                forecastImage = R.drawable.snow,
                condition = "Snow",
                tempHigh = 3,
                tempLow = -10,
                precipitationType = "Light Snow",
                precipitationPossibility = 50,
                precipitationAmount = 3,
                windSpeed = 15,
                humidity = 20
            )
        )
        val weather = Weather(
            current = current,
            forecast = forecast
        )

        _weather.value = weather
    }
}