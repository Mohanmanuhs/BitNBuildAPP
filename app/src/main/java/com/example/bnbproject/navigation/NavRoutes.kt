package com.example.bnbproject.navigation

sealed class NavRoutes(val route:String){

    data object Home:NavRoutes("Home")
    data object Login:NavRoutes("Login")
    data object Register:NavRoutes("Register")

    data object BottomNav:NavRoutes("BottomNav")


    data object Splash:NavRoutes("Splash")
    data object MarketSpace:NavRoutes("MarketSpace")
    data object Page3:NavRoutes("Page3")

    data object SellingScreen:NavRoutes("SellingScreen")

    data object Page5:NavRoutes("Page5")
}