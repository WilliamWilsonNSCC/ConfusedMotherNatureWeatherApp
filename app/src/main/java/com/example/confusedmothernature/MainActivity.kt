package com.example.confusedmothernature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.confusedmothernature.ui.theme.ConfusedMotherNatureTheme
import com.example.confusedmothernature.ui.screens.CurrentWeather
import com.example.confusedmothernature.ui.screens.DailyForecast
import kotlin.getValue

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConfusedMotherNatureTheme {
                DisplayUI(mainViewModel)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayUI(mainViewModel: MainViewModel){

    val navController = rememberNavController()
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text("Halifax, Nova Scotia")
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                NavigationBarItem(
                    label = {
                        Text("Current")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_current_location),
                            contentDescription = "Current Weather"
                        )
                    },
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
                        navController.navigate("current")
                    }
                )

                NavigationBarItem(
                    label = {
                        Text("Daily")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_daily),
                            contentDescription = "Daily Forecast"
                        )
                    },
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
                        navController.navigate("Daily")
                    }
                )
            }
        }
    )
    {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "current",
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = "current"){
                CurrentWeather(mainViewModel)
            }

            composable(route = "Daily"){
                DailyForecast(mainViewModel)
            }
        }
    }
}


//@Composable
//fun Greeting() {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Cyan)
//    ) {
//        Row(
//            horizontalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .fillMaxWidth(.75f)
//        )
//        {
//            Image(painter = painterResource(id = R.drawable.android_logo), contentDescription = "Android Logo")
//        }
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier
//                .background(Color.LightGray)
//                .fillMaxWidth(1f)
//        ) {
//            Text(
//                text = "Hello"
//            )
//            Text(
//                text = "Android"
//            )
//            Text(
//                text = "Welcome to my app"
//            )
//        }
//    }
//}