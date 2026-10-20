package com.example.pageturner.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pageturner.R
import com.example.pageturner.ui.components.Background
import com.example.pageturner.ui.components.common.Input

@Composable
fun ResetPasswordScreen(navController: NavController){
    var confPass by remember { mutableStateOf("") }
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
                ) {
                    Text(
                        "< Back to sign in",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "SECURE YOUR NEXT CHAPTER",
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 12.sp
                    )
                    Text(
                        "Set a new password",
                        color=Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Choose a password you haven’t used for this account before.",
                        color= MaterialTheme.colorScheme.surface,
                        fontSize = 14.sp,

                    )
                }


                Input(
                    value = password,
                    onValueChange = { password = it },
                    label = "New Password",
                    placeholder = "Enter your new password",
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )
                Input(
                    value = confPass,
                    onValueChange = { confPass = it },
                    label = "Confirm new password",
                    placeholder = "Re-enter your new password",
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )


                Button(
                    onClick = {navController.navigate("login")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text("Reset password",
                        color = MaterialTheme.colorScheme.background,
                        fontWeight = FontWeight.SemiBold)
                }


            }

        }
    }

}
