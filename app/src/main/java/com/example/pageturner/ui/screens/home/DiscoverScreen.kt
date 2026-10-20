package com.example.pageturner.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.pageturner.data.SampleBooks
import com.example.pageturner.ui.components.Background
import com.example.pageturner.ui.components.common.Input

@Composable
fun DiscoverScreen(navController: NavHostController){
    var search by remember { mutableStateOf("") }
    val books= SampleBooks.books
    Background {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(25.dp)
        ) {
            Text(
                "Find your next story",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            )
            Input(
                label = "",
                value = search,
                onValueChange = {search=it},
                placeholder = "Search book,author ..."

            )
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                OutlinedButton(onClick =   {}
                ,
                    modifier = Modifier.height(32.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filter",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text("Filters")
                    }
                }
                OutlinedButton(
                    onClick =   {},
                    modifier = Modifier.height(32.dp)

                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp)

                    ) {

                        Text("Sort: Relevance")
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "ARrow"
                        )
                    }
                }
            }

            Spacer(Modifier.height(30.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(
                    items=books,
                    key={book->book.id}

                ){
                    book->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(15.dp),

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .clickable(onClick = {navController.navigate("book_details/${book.id}")}),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier.weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = book.thumbnailUrl,
                                    contentDescription = book.title,
                                    modifier = Modifier
                                        .width(60.dp)
                                        .height(90.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(5.dp)
                                ) {
                                    Text(
                                        book.title,
                                        color = MaterialTheme.colorScheme.secondary,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium
                                    )

                                    Text(
                                        book.author,
                                        color = MaterialTheme.colorScheme.surface,
                                        fontSize = 14.sp
                                    )

                                    Text(
                                        book.shortDescription,
                                        color = MaterialTheme.colorScheme.tertiary,
                                        fontSize = 13.sp,
                                        maxLines = 2
                                    )
                                }
                            }

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "View book details",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        HorizontalDivider()
                    }
                }
            }
        }
    }

}