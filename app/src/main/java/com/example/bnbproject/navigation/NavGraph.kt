package com.example.bnbproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bnbproject.screens.HomeScreen
import com.example.bnbproject.screens.Page2Screen
import com.example.bnbproject.screens.Page3Screen
import com.example.bnbproject.screens.Page4Screen
import com.example.bnbproject.screens.Page5Screen
import com.example.bnbproject.screens.SplashScreen

@Composable
fun NavGraphScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = NavRoutes.Splash.route) {
        composable(NavRoutes.Splash.route) {
            SplashScreen(navController)
        }

        composable(NavRoutes.BottomNav.route) {
            BottomNavScreen(navController)
        }

        composable(NavRoutes.Home.route) {
            HomeScreen()
        }

        composable(NavRoutes.Page2.route) {
            Page2Screen()
        }
        composable(NavRoutes.Page3.route) {
            Page3Screen()
        }
        composable(NavRoutes.Page4.route) {
            Page4Screen()
        }
        composable(NavRoutes.Page5.route) {
            Page5Screen()
        }
    }
}