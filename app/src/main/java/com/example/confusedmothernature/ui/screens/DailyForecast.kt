package com.example.confusedmothernature.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
        Row(verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth(1f)
                .fillMaxHeight(.085f)
        ){
            Column(modifier = Modifier
                .padding(top = 20.dp)){
                Text("Halifax, NS")
            }
        }
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(.875f)
                .background(Color.LightGray)
        ){
            Image(painter = painterResource(id = R.drawable.rain), contentDescription = "rain")
            Text("Rain")
            Text("18\u2103 High  8\u2103 Low")
            Text("Heavy Rain, Chance of Rain 90%, Amount 15mm,")
            Text("Max Winds 15 km/h, Humidity 20%")
            Text("____________________________________________________")

            Spacer(modifier = Modifier.height(30.dp))

            Image(painter = painterResource(id = R.drawable.rain), contentDescription = "rain")
            Text("Rain")
            Text("18\u2103 High  8\u2103 Low")
            Text("Heavy Rain, Chance of Rain 90%, Amount 15mm,")
            Text("Max Winds 15 km/h, Humidity 20%")
            Text("____________________________________________________")

            Spacer(modifier = Modifier.height(30.dp))

            Image(painter = painterResource(id = R.drawable.rain), contentDescription = "rain")
            Text("Rain")
            Text("18\u2103 High  8\u2103 Low")
            Text("Heavy Rain, Chance of Rain 90%, Amount 15mm,")
            Text("Max Winds 15 km/h, Humidity 20%")
            Text("____________________________________________________")
        }
        Row(verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
        ){
            Column(modifier = Modifier.padding(horizontal = 100.dp, vertical = 30.dp)){
                Text("Now")
            }
            Column(modifier = Modifier.padding(horizontal = 50.dp, vertical = 30.dp)){
                Text("Daily")
            }
        }
    }
}