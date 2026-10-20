package com.example.pageturner.ui.screens.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.pageturner.ui.components.Background

@Composable
fun ProfileScreen(navController: NavHostController){
    Background {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(25.dp)
                .verticalScroll(rememberScrollState()),

            verticalArrangement = Arrangement.spacedBy(50.dp)
        ){
            Text(
                "Your story, so far",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Card(
                    modifier = Modifier.size(70.dp)
                        .border(0.5.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(100.dp)),
                    shape = RoundedCornerShape(100.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0XFF322D20)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "MC",
                            color = MaterialTheme.colorScheme.tertiary,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Text(
                    text = "Maya Chen",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "maya.chen@example.com",
                    color = MaterialTheme.colorScheme.surface,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Curious about worlds, words and secrets.",
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center
                )


            }


        }
    }
    }