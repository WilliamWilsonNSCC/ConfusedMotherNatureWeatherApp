package com.example.confusedmothernature.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.confusedmothernature.R

@Composable
fun CurrentWeather(){
    WeatherDisplay()
}

@Composable
fun WeatherDisplay() {
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
                .fillMaxHeight(.88f)
                .background(Color.LightGray)
        ){
            Image(painter = painterResource(id = R.drawable.rain), contentDescription = "rain")
            Text("Rain")
            Text("18\u2103")
            Text("Feels like 16\u2103")
            Text("P.O.P 100%")
            Text("Precipitation 13.4mm")
            Text("Wind SSE 24 km/h")
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