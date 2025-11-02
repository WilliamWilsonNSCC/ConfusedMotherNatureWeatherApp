package com.example.confusedmothernature.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.confusedmothernature.MainViewModel
import com.example.confusedmothernature.models.Weather

@Composable
fun CurrentWeather(mainViewModel: MainViewModel){

    val weather by mainViewModel.weather.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 40.dp, bottom = 40.dp)
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
    ){
        if(weather == null){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp))
                Text("Loading current conditions...", style = MaterialTheme.typography.titleMedium)
            }
        } else {
            CurrentWeatherDisplay(weather!!)
        }
    }
}

@Composable
fun CurrentWeatherDisplay(weather: Weather){
    val current = weather.current
    val location = weather.location

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = location.name,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            WeatherIcon(
                iconUrl = current.condition.icon,
                contentDescription = current.condition.text
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "${current.temp_c.format(0)}\u2103",
                style = MaterialTheme.typography.displayLarge
            )
        }

        Text(
            text = current.condition.text,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
        )

        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        // Detailed Current Stats
        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
//            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Feels like ${current.feelslike_c.format(0)}\u2103")
            Text(text = "Wind Speed ${current.wind_kph.format(0)} km/h")
            Text(text = "Wind Direction ${current.wind_dir}")
            Text(text = "Precipitation ${current.precip_mm.format(1)} mm")
        }
    }
}