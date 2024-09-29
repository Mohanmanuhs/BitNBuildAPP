package com.example.bnbproject.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bnbproject.screens.HomeScreen
import com.example.bnbproject.screens.ItemDetailsScreen
import com.example.bnbproject.screens.LoginScreen
import com.example.bnbproject.screens.MarketSpace
import com.example.bnbproject.screens.Page3Screen
import com.example.bnbproject.screens.Page5Screen
import com.example.bnbproject.screens.RegisterScreen
import com.example.bnbproject.screens.SellDetailsScreen
import com.example.bnbproject.screens.SellingScreen
import com.example.bnbproject.screens.SplashScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
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
        composable(NavRoutes.MarketSpace.route) {
            MarketSpace(navController)
        }
        composable(NavRoutes.Login.route) {
            LoginScreen(navController)
        }
        composable(NavRoutes.Register.route) {
            RegisterScreen(navController)
        }
        composable(NavRoutes.MarketDetails.route) {backStackEntry->
            val data = backStackEntry.arguments!!.getString("data")
            data?.let {
                Log.d("MyTag",it)
                SellDetailsScreen(it)
            }
        }
        composable(NavRoutes.Page3.route) {
            Page3Screen()
        }
        composable(NavRoutes.ItemDetails.route) {backStackEntry->
            val data = backStackEntry.arguments!!.getString("data")
            data?.let {
                Log.d("MyTag",it)
                ItemDetailsScreen(it)
            }
        }
        composable(NavRoutes.SellingScreen.route) {
            SellingScreen()
        }
        composable(NavRoutes.Page5.route) {
            Page5Screen(navController)
        }
    }

}