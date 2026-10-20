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
fun SignUpScreen(navController: NavController){
    var name by remember { mutableStateOf("") }
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
                        "JOIN THE READING CIRCLE",
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 12.sp
                    )
                    Text(
                        "Create your account",
                        color=Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Start your reading journey with a profile that remembers your tastes and recommends books just for you.",
                        color= MaterialTheme.colorScheme.surface,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Input(
                    value = name,
                    onValueChange = { name = it },
                    label = "Name",
                    placeholder = "Enter your fullname"
                )
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
                    placeholder = "Setup your password",
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text("Create account",
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
                        "Already have an account?",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "Sign in",
                        modifier = Modifier.clickable(onClick = {navController.navigate("login")}),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 15.sp

                    )

                }
            }

        }
    }

}
