package com.example.pageturner.ui.navigation



import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import com.example.pageturner.ui.components.common.BottomBar
import com.example.pageturner.ui.components.common.Topbar
import com.example.pageturner.ui.screens.home.BookDetailsScreen
import com.example.pageturner.ui.screens.home.DiscoverScreen
import com.example.pageturner.ui.screens.home.HomeScreen
import com.example.pageturner.ui.screens.home.LibraryScreen
import com.example.pageturner.ui.screens.home.ProfileScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Topbar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen()
            }

            composable("discover") {
                DiscoverScreen(navController)
            }

            composable("library") {
                LibraryScreen(navController)
            }

            composable("profile") {
                ProfileScreen(navController)
            }
            composable("book_details/{bookId}") { backStackEntry ->
                val bookId = backStackEntry.arguments?.getString("bookId")

                if (bookId != null) {
                    BookDetailsScreen(bookId = bookId,navController)
                }
            }
        }
    }
}


