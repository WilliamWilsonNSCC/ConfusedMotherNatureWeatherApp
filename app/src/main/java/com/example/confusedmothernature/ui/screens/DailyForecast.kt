package com.example.confusedmothernature.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.confusedmothernature.MainViewModel
import com.example.confusedmothernature.models.ForecastDay

@Composable
fun DailyForecast(mainViewModel: MainViewModel){
    WeeklyDisplay(mainViewModel)
}

@Composable
fun WeeklyDisplay(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()
    val dailyForecastList: List<ForecastDay> = weather?.forecast?.forecastday ?: emptyList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = weather?.location?.name ?: "Daily Forecast",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // 'day' here is an instance of the Forecast data class
            items(dailyForecastList) { day ->
                ForecastItem(day)
                HorizontalDivider(Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Composable
fun ForecastItem(forecastDay: ForecastDay) {
    val dayDetails = forecastDay.day
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(forecastDay.date, style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Weather Icon (using the condition icon URL from the API)
            WeatherIcon(
                iconUrl = dayDetails.condition.icon,
                contentDescription = dayDetails.condition.text
            )

            // High / Low Temperature
            Text(
                text = "${dayDetails.maxtemp_c.format(0)}\u2103 / ${dayDetails.mintemp_c.format(0)}\u2103",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // Detailed Conditions
        Text(text = dayDetails.condition.text, style = MaterialTheme.typography.titleLarge)

        // Other forecast data fields:
        Text(text = "Rain Chance: ${dayDetails.chance_of_rain}%", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Snow Chance: ${dayDetails.chance_of_snow}%", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Wind: ${dayDetails.wind_kph.format(0)} km/h", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Humidity: ${dayDetails.humidity}%", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Precipitation: ${dayDetails.precip_mm.format(1)} mm", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun WeatherIcon(iconUrl: String, contentDescription: String) {
    val fullUrl = if (iconUrl.startsWith("//")) "https:$iconUrl" else iconUrl

    AsyncImage(
        model = fullUrl,
        contentDescription = contentDescription,
        modifier = Modifier.size(56.dp)
    )
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)