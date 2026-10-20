package com.example.pageturner.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.pageturner.R
import com.example.pageturner.ui.components.Background


data class Btn(
    val id: Int,
    val name: String
)

val btns=listOf(
    Btn(
        1,
        "Want to read"
    ),
    Btn(
        2,
        "Reading"
    ),
    Btn(
        3,
        "Finished"
    ),
)


@Composable
fun LibraryScreen(navController: NavHostController){

    var active by remember { mutableStateOf(1) }
    Background(
        {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(25.dp)
                    .verticalScroll(rememberScrollState()),

                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        "Your reading life",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        "Make room for your next favourite.",
                        color = MaterialTheme.colorScheme.surface,
                        fontSize = 14.sp,
                    )
                    Spacer(Modifier.height(3.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        modifier = Modifier
                            .background(Color(0XFF10241C), shape = RoundedCornerShape(110.dp))
                            .padding(5.dp)
                    ) {
                        btns.forEach { btn ->
                            TextButton(
                                onClick = { active = btn.id },
                                modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.textButtonColors(
                                    containerColor = if (active == btn.id) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        Color.Transparent
                                    },
                                    contentColor = if (active == btn.id) {
                                        MaterialTheme.colorScheme.background
                                    } else {
                                        MaterialTheme.colorScheme.surface
                                    }
                                )
                            ) {
                                Text(btn.name)
                            }
                        }
                    }
                }



                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.lib),
                        contentDescription = "bookmark",
                        modifier = Modifier.size(65.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        "A story belongs here",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Your Want to read shelf is empty. Save books that catch your eye and come back when the moment feels right.",
                        color = MaterialTheme.colorScheme.surface,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                    )

                    Button(
                        onClick = {navController.navigate("discover")},
                        modifier = Modifier.height(45.dp)
                            .fillMaxWidth()

                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "arrow",
                                tint = Color.Black,
                                modifier = Modifier.size(20.dp)

                            )
                            Text(
                                "Discover books",
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold
                                )
                        }
                    }
                }

                Text("Look for the bookmark on a book’s details to save it to this shelf.",
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.surface
                    )
            }
        }
    )
}