package com.example.confusedmothernature.models

data class Weather(
    val current: Current,
    val forecast: List<Forecast>
) {
    companion object
}

data class Current(
    //Weather Image
    val currentImage: Int,
    val curCondition: String,
    val temperature: Int,
    val feelLike: Int,
    val precipitationPossibility: Int,
    val precipitationType: String,
    val precipitationAmount: Int,
    val curWindDir: String,
    val curWindSpeed: Int,

)

data class Forecast(
    val date: String,
    //Image
    val forecastImage: Int,
    val condition: String,
    val tempHigh: Int,
    val tempLow: Int,
    val precipitationType: String,
    val precipitationPossibility: Int,
    val precipitationAmount: Int,
    val windSpeed: Int,
    val humidity: Int

)