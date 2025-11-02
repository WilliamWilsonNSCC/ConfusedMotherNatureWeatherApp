package com.example.confusedmothernature.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: ForecastContainer
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double
)
data class Current(
    val condition: Condition,
    val temp_c: Double,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val chance_of_rain: Double,
    val chance_of_snow: Double,
    val precipitationType: String,
    val precip_in: Double,
    val precip_mm: Double,
    val wind_dir: String,
    val wind_kph: Double

)

data class ForecastDay(
    val day: DayDetails,
    val date: String,
)

data class DayDetails(
    val condition: Condition,
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val precipitationType: String,
    val chance_of_rain: Double,
    val chance_of_snow: Double,
    val precip_in: Double,
    val precip_mm: Double,
    val wind_kph: Double,
    val humidity: Double

)

data class ForecastContainer(
    @SerializedName("forecastday")
    val forecastday: List<ForecastDay>
)

data class Conditions(
    val condition: Condition
)

data class Condition(
    val icon: String,
    val text: String
)