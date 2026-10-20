package com.example.pageturner.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("login"){
            popUpTo("splash"){
                inclusive=true
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(com.example.pageturner.R.drawable.bg),
            contentDescription = "Book background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(com.example.pageturner.R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(0.5f)
                )
            Text(
                "YOUR NEXT BOOK PERSONALISED",
                modifier = Modifier.offset(y=-40.dp),
                color= MaterialTheme.colorScheme.tertiary
                )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .align(Alignment.BottomCenter)

        ) {
            Text(
                "Books That Know",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 45.sp
                )
            Text(
                "You",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 45.sp
                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "An AI-powered reading companion that discovers books for your interests and evolving tastes.",
                color = MaterialTheme.colorScheme.surface,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))

        }
    }
}
