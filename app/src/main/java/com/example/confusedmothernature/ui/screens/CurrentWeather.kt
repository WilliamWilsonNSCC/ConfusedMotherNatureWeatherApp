package com.example.confusedmothernature.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.confusedmothernature.MainViewModel
import coil.compose.rememberAsyncImagePainter

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
        Image(
            painter = rememberAsyncImagePainter(weather?.current?.currentImage),
            contentDescription = "rain"
        )
        Text(text = weather?.current?.curCondition.toString(), style = MaterialTheme.typography.titleLarge)
        Text(text = "${weather?.current?.temperature}\u2103", style = MaterialTheme.typography.titleSmall)
        Text(text = "Feels like ${weather?.current?.feelLike}\u2103", style = MaterialTheme.typography.titleSmall)
        Text(text = "P.O.P ${weather?.current?.precipitationPossibility}%", style = MaterialTheme.typography.titleSmall)
        Text(text = "${ weather?.current?.precipitationType } ${ weather?.current?.precipitationAmount }cm", style = MaterialTheme.typography.titleSmall)
        Text(text = "Wind ${ weather?.current?.curWindDir } ${ weather?.current?.curWindSpeed }", style = MaterialTheme.typography.titleSmall)
    }
}