package com.example.pageturner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pageturner.ui.screens.auth.ForgotPasswordScreen
import com.example.pageturner.ui.screens.auth.LinkScreen
import com.example.pageturner.ui.screens.auth.LoginScreen
import com.example.pageturner.ui.screens.auth.ResetPasswordScreen
import com.example.pageturner.ui.screens.auth.SignUpScreen
import com.example.pageturner.ui.screens.auth.SplashScreen

@Composable
fun AppNavigation(){
    var navController=rememberNavController()

    NavHost(
        navController=navController,
        startDestination = "splash"
    ){
        composable("splash"){
            SplashScreen(navController)
        }
        composable("login"){
            LoginScreen(navController)
        }
        composable("signup"){
            SignUpScreen(navController)
        }
        composable("forgotPassword"){
            ForgotPasswordScreen(navController)
        }
        composable("link") {
            LinkScreen(navController)
        }
        composable("resetPassword"){
            ResetPasswordScreen(navController)
        }

        composable("main"){
            MainNavigation()
        }




    }

}
