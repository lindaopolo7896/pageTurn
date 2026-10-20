package com.example.pageturner.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pageturner.R
import com.example.pageturner.data.GenreList
import com.example.pageturner.data.SampleBooks
import com.example.pageturner.ui.components.Background
import com.example.pageturner.ui.components.common.CardCom

@Composable
fun HomeScreen(){
    val popularBooks= SampleBooks.books.filter {  it.category=="Popular"}
    val trendingBooks= SampleBooks.books.filter {  it.category=="Trending"}
    val recentBooks= SampleBooks.books.filter {  it.category=="Recently Added"}


    Background {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(25.dp)
                .verticalScroll(rememberScrollState()),

            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    "WELCOME TO YOUR LIBRARY",
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 12.sp
                )

                Text(
                    "Home",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    "Curated collections, popular books, trending titles, and new arrivals to browse.",
                    color = MaterialTheme.colorScheme.surface,
                    fontSize = 16.sp,
                )
            }
//        CURRENT READ
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xff183027)
                ),
                modifier = Modifier
                    .border(1.dp, Color(0xff405045), shape = RoundedCornerShape(12.dp))

            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.emb),
                            contentDescription = "book cover",
                            modifier = Modifier.height(90.dp).width(70.dp)
                                .clip(RoundedCornerShape(12.dp
                                )),
                            contentScale = ContentScale.Fit,


                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            Text(
                                "CONTINUE READING",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.tertiary,

                            )
                            Text(
                                "Embarke",
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.secondary,


                                )
                            Text(
                                "Susan Clarke | 96 / 240 pages",
                                fontSize = 14.sp,
                                color = Color(0xffC1C9C1)

                                )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "Update progress",
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 14.sp
                                )
                                Icon(
                                    imageVector = Icons.Outlined.ArrowForward,
                                    contentDescription = "forward arrow",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier
                                        .size(15.dp)
                                )
                            }






                        }
                    }

                    Box(modifier = Modifier.fillMaxWidth()
                        .height(5.dp)
                        .background(Color(0xff405045), shape = RoundedCornerShape(30.dp))

                    ){
                        Box(modifier = Modifier.fillMaxWidth(0.4f)
                            .height(5.dp)
                            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(30.dp))

                        )
                    }

                    Text(
                        "40% read | Sample copy, page total set by you",
                        fontSize = 14.sp,
                        color = Color(0xffC1C9C1)

                    )
                }
            }

//        GENRES
            Column(
                verticalArrangement = Arrangement.spacedBy(11.dp)
            ) {

                Column() {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Browse Genres",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Discover",
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 14.sp
                            )
                            Icon(
                                imageVector = Icons.Outlined.ArrowForward,
                                contentDescription = "forward arrow",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .size(15.dp)
                            )
                        }
                    }
                }

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(items = GenreList.genres.take(3)) { genre ->
                        Text(
                            text = genre.name,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier
                                .background(
                                    Color(0xff322D20),
                                    RoundedCornerShape(20.dp)

                                )
                                .border(
                                    1.dp,
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(20.dp)
                                )

                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 4.dp
                                )
                        )
                    }
                }
                Text(
                    "Browse genre collections and discover more books.",
                    color = MaterialTheme.colorScheme.surface,
                    fontSize = 14.sp,
                )


            }

            CardCom(
                title="Popular books",
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.85f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        popularBooks.take(2).forEach { book ->
                            Column(
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                AsyncImage(
                                    model = book.coverImageUrl,
                                    contentDescription = book.title,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(140.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    book.title,
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.secondary
                                )

                                Text(
                                    book.author,
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.surface


                                )

                            }
                        }
                    }
                }
            )

            CardCom(
                title="Trending Titles",
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        trendingBooks.take(2).forEach { book ->
                            Column(
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                AsyncImage(
                                    model = book.coverImageUrl,
                                    contentDescription = book.title,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(140.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    book.title,
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.secondary
                                )

                                Text(
                                    book.author,
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.surface


                                )

                            }
                        }
                    }
                }
            )

            CardCom(
                title="Recently Added",
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.85f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        recentBooks.take(2).forEach { book ->
                            Column(
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                AsyncImage(
                                    model = book.coverImageUrl,
                                    contentDescription = book.title,
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(140.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    book.title,
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.secondary
                                )

                                Text(
                                    book.author,
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.surface


                                )

                            }
                        }
                    }
                }
            )
        }
    }
}