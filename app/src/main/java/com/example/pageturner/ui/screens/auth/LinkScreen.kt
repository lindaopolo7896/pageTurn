package com.example.pageturner.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pageturner.ui.components.Background

@Composable
fun LinkScreen(navController: NavController){


    Background {
         Box(
             modifier = Modifier.fillMaxSize()
         ) {

             Image(
                 painter = painterResource(com.example.pageturner.R.drawable.logo),
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
                         painter = painterResource(com.example.pageturner.R.drawable.passkey),
                         contentDescription = "logo",
                         contentScale = ContentScale.Crop,
                         modifier = Modifier.size(50.dp)
                     )
                     Text(
                         "Check your email",
                         color=Color.White,
                         fontSize = 30.sp,
                         fontWeight = FontWeight.Medium
                     )
                     Text(
                         "We've requested a reset link for:",
                         color= MaterialTheme.colorScheme.surface,
                         fontSize = 14.sp,
                     )


                 }

                 Card(
                     colors = CardDefaults.cardColors(
                         containerColor = Color(0XFF183027).copy(alpha = 0.83f)
                     ),
                     modifier = Modifier

                         .border(1.dp, Color(0XFF405045), shape = RoundedCornerShape(10.dp))
                 ) {
                     Column(
                         modifier = Modifier.padding(20.dp)
                     ) {
                         Text("mayachen@gmail.com",
                             color = MaterialTheme.colorScheme.secondary
                         )
                         Spacer(modifier = Modifier.height(20.dp))
                         Text("It may take a few minutes to arrive. Check your spam folder too.",
                             color = Color(0xffC1C9C1)
                         )


                     }
                 }

                 Button(
                     onClick = {},
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(48.dp)
                 ) {
                     Text("Resend reset link",
                         color = MaterialTheme.colorScheme.background,
                         fontWeight = FontWeight.SemiBold)
                 }

                 Text(
                     "Change email address",
                     modifier = Modifier.clickable(onClick = {navController.navigate("resetPassword")})
                         .fillMaxWidth(),
                     textAlign = TextAlign.Center,
                     color = MaterialTheme.colorScheme.primary,
                     fontSize = 16.sp

                 )


             }

         }
     }

}
