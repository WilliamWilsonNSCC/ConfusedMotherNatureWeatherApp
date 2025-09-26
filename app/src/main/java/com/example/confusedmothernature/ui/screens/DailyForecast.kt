package com.example.confusedmothernature.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.confusedmothernature.R

@Composable
fun DailyForecast(){
    WeeklyDisplay()
}

@Composable
fun WeeklyDisplay() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical=40.dp)
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .background(Color.Gray)
        ){
            Text("Tue Nov 25")
            Image(painter = painterResource(id = R.drawable.snow), contentDescription = "rain")
            Text("Snow")
            Text("3\u2103 High  -10\u2103 Low")
            Text("Light Snow, Chance of Snow 50%, Amount 3cm,")
            Text("Max Winds 15 km/h, Humidity 20%")
            Text("____________________________________________________")

            Spacer(modifier = Modifier.height(30.dp))

            Text("Wed Nov 26")
            Image(painter = painterResource(id = R.drawable.rain_heavy), contentDescription = "rain")
            Text("Rain")
            Text("7\u2103 High  3\u2103 Low")
            Text("Heavy Rain, Chance of Rain 90%, Amount 15mm,")
            Text("Max Winds 15 km/h, Humidity 20%")
            Text("____________________________________________________")

            Spacer(modifier = Modifier.height(30.dp))

            Text("Thu Nov 27")
            Image(painter = painterResource(id = R.drawable.snow), contentDescription = "rain")
            Text("Snow")
            Text("-2\u2103 High  -13\u2103 Low")
            Text("Very Light Snow, Chance of Snow 10%, Amount >1cm,")
            Text("Max Winds 15 km/h, Humidity 20%")
            Text("____________________________________________________")
        }
    }
}