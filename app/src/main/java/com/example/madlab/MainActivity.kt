package com.example.madlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.madlab.ui.theme.MADLABTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MADLABTheme {
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = "login_screen"){
                    composable("login_screen"){
                        Login(navController)
                    }
                    composable("register_screen"){
                        selectCity(navController)
                    }
                }

            }
        }
    }
}


@Composable
fun Login(navController: NavController){

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(1f)
    ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
        Text(text = "Sky Sight")
    }

    Button(onClick = { navController.navigate("register_screen") }, modifier = Modifier
            .padding(20.dp, 20.dp, 15.dp, 20.dp)
            .fillMaxWidth()){
            Text("Show weather")
        }

    }



@Composable
fun selectCity(navController: NavController){

    var cityName by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(48.dp) // Adjust icon size
        )
        Image(
            painter = painterResource(id = R.drawable.map),
            contentDescription = "map",
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f) // Adjust map size
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f) // Adjust size of text field and button container
                .background(Color.Black)
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = cityName,
                onValueChange = { cityName = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(color = Color.White),
                label = { Text("City name", color = Color.White) }
            )

            Button(
                onClick = { navController.navigate("login_screen") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Show Weather")
            }
        }
    }
}

