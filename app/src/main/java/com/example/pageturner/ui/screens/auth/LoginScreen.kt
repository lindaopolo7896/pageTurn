package com.example.pageturner.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pageturner.R
import com.example.pageturner.ui.components.Background
import com.example.pageturner.ui.components.common.Input

@Composable
fun LoginScreen(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Background {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(0.5f)
                    .align(Alignment.TopCenter)
            )

            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(25.dp)
                    .align(Alignment.Center)
                ,
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(3.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "YOUR READING LIFE, TOGETHER",
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 12.sp
                        )
                    Text(
                        "Welcome back",
                        color=Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium
                        )
                    Text(
                        "Your next chapter is waiting. Sign in to your books and discoveries.",
                        color= MaterialTheme.colorScheme.surface,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Input(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email",
                    placeholder = "Enter your email",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )
                Input(
                    value = password,
                    onValueChange = { password = it },
                    label = "Password",
                    placeholder = "Enter your password",
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )
                Text(
                    "Forgot password?",
                    modifier = Modifier.clickable(onClick = {navController.navigate("forgotPassword")})
                        .offset(y=-10.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 15.sp


                )

                Button(
                    onClick = {navController.navigate("main")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                    ) {
                    Text("Sign in",
                        color = MaterialTheme.colorScheme.background,
                        fontWeight = FontWeight.SemiBold)
                }

                Row(
                    modifier = Modifier.offset(y=-15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "New to Page Turn?",
                        color = Color.White,
                        fontSize = 13.sp
                        )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "Create account",
                        modifier = Modifier.clickable(onClick = {navController.navigate("signup")}),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 15.sp

                        )

                }
            }

        }
        }

}
