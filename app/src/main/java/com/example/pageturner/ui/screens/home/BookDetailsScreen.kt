package com.example.pageturner.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.pageturner.data.Genre
import com.example.pageturner.data.GenreList
import com.example.pageturner.data.SampleBooks
import com.example.pageturner.ui.components.Background
import com.example.pageturner.ui.components.common.CardCom

@Composable
fun BookDetailsScreen(bookId: String,navController: NavHostController) {
    val book = SampleBooks.books.find { it.id == bookId }

    if (book != null) {
        val genre = GenreList.genres.find { it.id == book.genreId }

        Background {
            Column(
                modifier = Modifier.padding(horizontal =  25.dp, vertical = 10.dp).verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(20.dp),

            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.clickable(onClick = {navController.popBackStack()})
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = book.coverImageUrl,
                        contentDescription = book.title,
                        modifier = Modifier
                            .width(120.dp)
                            .height(180.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = book.title,
                            modifier = Modifier
                                .width(150.dp),
                            lineHeight = 35.sp,
                            fontSize = 28.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )

                        Text(
                            text = book.author,
                            fontSize = 15.sp,
                            color = MaterialTheme.colorScheme.surface
                        )

                        genre?.let {
                            Text(
                                text = it.name,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }

             Column(
                 verticalArrangement = Arrangement.spacedBy(15.dp)
             ) {
                 Text(
                     text = book.subtitle,

                     fontSize = 22.sp,
                     color = MaterialTheme.colorScheme.secondary
                 )
                 Text(
                     text = book.longDescription,
                     fontSize = 15.sp,
                     color = MaterialTheme.colorScheme.surface
                 )
             }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xff183027)
                    ),
                    modifier = Modifier
                        .border(1.dp, Color(0xff405045), shape = RoundedCornerShape(12.dp))

                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = "In the curated collection",

                            fontSize = 22.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = "Editorial picks featuring lyrical writing, imaginative worlds and atmospheric fantasy.",
                            fontSize = 15.sp,
                            color = MaterialTheme.colorScheme.surface
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            genre?.let {
                                Text(
                                    text = "Browse ${it.name}",
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }

                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp)
                            ,
                        border = BorderStroke(
                            1.dp,
                            Color(0xFF405045) // Green border
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff10241C),

                        )

                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Bookmark,
                                contentDescription = "bookmark",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)

                            )

                            Text(
                                "Track reading",
                                color= MaterialTheme.colorScheme.secondary,
                                fontWeight = FontWeight.Medium

                            )
                        }
                    }

                    Button(onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp)
                    ) {


                            Text(
                                "Add to reading list",
                                color = MaterialTheme.colorScheme.background,
                                fontWeight = FontWeight.Medium
                            )

                    }
                }

                Text(
                    text = "Save to Want to read, or track your own copy. No ebook included. ",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }
    }

}