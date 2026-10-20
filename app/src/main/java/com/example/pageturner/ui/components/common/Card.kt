package com.example.pageturner.ui.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardCom(
    title: String,
    content:@Composable ()-> Unit
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xff183027)
        ),
        modifier = Modifier
            .border(1.dp, Color(0xff405045), shape = RoundedCornerShape(12.dp))
            .fillMaxHeight()

    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    title,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                        "See all",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                )

                }


            content()
        }
    }
}