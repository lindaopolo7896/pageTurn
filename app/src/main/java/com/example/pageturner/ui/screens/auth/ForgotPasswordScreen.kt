package com.example.pageturner.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun ForgotPasswordScreen(navController: NavController){
    var email by remember { mutableStateOf("") }


    Background{
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
                      verticalArrangement = Arrangement.spacedBy(8.dp),
                  ) {
                      Text(
                          "< Back to sign in",
                          color = MaterialTheme.colorScheme.tertiary,
                          fontSize = 14.sp
                      )
                      Image(
                          painter = painterResource(R.drawable.passkey),
                          contentDescription = "logo",
                          contentScale = ContentScale.Crop,
                          modifier = Modifier.size(50.dp)
                      )
                      Text(
                          "A fresh start",
                          color=Color.White,
                          fontSize = 30.sp,
                          fontWeight = FontWeight.Medium
                      )
                      Text(
                          "Enter the email you use for Page Turn. We’ll send a link to reset your password.",
                          color= MaterialTheme.colorScheme.surface,
                          fontSize = 14.sp,
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


                  Button(
                      onClick = {navController.navigate("link")},
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(48.dp)
                  ) {
                      Text("Send reset link",
                          color = MaterialTheme.colorScheme.background,
                          fontWeight = FontWeight.SemiBold)
                  }



              }

          }
      }

}
