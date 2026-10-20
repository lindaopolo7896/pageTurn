package com.example.pageturner.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class Nav(
    val id: Int,
    val name: String,
    val icon: ImageVector,
    val link: String
)

val navs=listOf(
    Nav(
        1,
        "Home",
        Icons.Outlined.Home,
         "home"
    ),
    Nav(
        2,
        "Search",
        Icons.Outlined.Search,
        "discover"
    ),
    Nav(
        3,
        "My books",
        Icons.Outlined.LibraryBooks,
        "library"
    ),
    Nav(
        4,
        "Profile",
        Icons.Outlined.Person,
        "profile"
    ),

)

@Composable
fun BottomBar(navController: NavHostController){
    var active by remember { mutableStateOf(1) }
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .background(Color(0xff10241C))
            .drawBehind {
                drawLine(
                    color = Color(0xff405045),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 1.dp.toPx()
                )
            }
            .padding(vertical = 20.dp, horizontal = 20.dp)
           ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        navs.forEach { nav ->
            Column(
                modifier = Modifier.clickable(onClick = {
                    navController.navigate(nav.link)
                    active=nav.id
                }),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = nav.icon,
                    contentDescription = nav.name,
                    modifier = Modifier
                        .size(20.dp),
                    tint = if(active==nav.id) {
                        MaterialTheme.colorScheme.primary
                    }else{
                        MaterialTheme.colorScheme.secondary
                    }
                )

                Text(nav.name, fontSize = 14.sp, color = if(active==nav.id) {
                    MaterialTheme.colorScheme.primary
                }else{
                    MaterialTheme.colorScheme.secondary
                })
            }
        }




    }
}