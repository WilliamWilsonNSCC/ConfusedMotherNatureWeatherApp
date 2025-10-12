package com.example.confusedmothernature.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.confusedmothernature.MainViewModel
import com.example.confusedmothernature.R

@Composable
fun DailyForecast(mainViewModel: MainViewModel){
    WeeklyDisplay(mainViewModel)
}

@Composable
fun WeeklyDisplay(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background()
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
        ){

        weather?.forecast?.forEach { day ->
            Text(text = day.date, style = MaterialTheme.typography.titleLarge)
            Image(
                painter = painterResource(id = R.drawable.snow),
                contentDescription = "Snow"
            )
            Text(text = day.condition, style = MaterialTheme.typography.titleLarge)
            Text(
                text = "${day.tempHigh}\u2103 / ${day.tempLow}\u2103",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "${day.precipitationType}\u2103 ${day.precipitationPossibility}\u2103",
                style = MaterialTheme.typography.titleSmall
            )
            Text(text = "Amount: ${day.tempHigh}mm", style = MaterialTheme.typography.titleSmall)
            Text(text = "Wind ${day.windSpeed} km/h", style = MaterialTheme.typography.titleSmall)
            Text(text = "${day.humidity}%", style = MaterialTheme.typography.titleSmall)
            Text("____________________________________________________")

        }

//            Text("Tue Nov 25")
//            Image(painter = painterResource(id = R.drawable.snow), contentDescription = "snow")
//            Text("Snow")
//            Text("3\u2103 High  -10\u2103 Low")
//            Text("Light Snow, Chance of Snow 50%, Amount 3cm,")
//            Text("Max Winds 15 km/h, Humidity 20%")
//            Text("____________________________________________________")
//
////            Spacer(modifier = Modifier.height(30.dp))
//
//            Text("Wed Nov 26")
//            Image(painter = painterResource(id = R.drawable.rain_heavy), contentDescription = "rain")
//            Text("Rain")
//            Text("7\u2103 High  3\u2103 Low")
//            Text("Heavy Rain, Chance of Rain 90%, Amount 15mm,")
//            Text("Max Winds 15 km/h, Humidity 20%")
//            Text("____________________________________________________")
//
////            Spacer(modifier = Modifier.height(30.dp))
//
//            Text("Thu Nov 27")
//            Image(painter = painterResource(id = R.drawable.snow), contentDescription = "rain")
//            Text("Snow")
//            Text("-2\u2103 High  -13\u2103 Low")
//            Text("Very Light Snow, Chance of Snow 10%, Amount >1cm,")
//            Text("Max Winds 15 km/h, Humidity 20%")
//            Text("____________________________________________________")
        }
    }
}