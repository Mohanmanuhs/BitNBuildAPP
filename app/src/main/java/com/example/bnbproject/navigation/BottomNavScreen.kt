package com.example.bnbproject.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Sell
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bnbproject.screens.HomeScreen
import com.example.bnbproject.screens.MarketSpace
import com.example.bnbproject.screens.Page3Screen
import com.example.bnbproject.screens.Page5Screen
import com.example.bnbproject.screens.SellingScreen

@Composable
fun BottomNavScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {
    val navController1 = rememberNavController()
    val listOfNavBarItems = listOf(
        NavBarItem(
            "Home", NavRoutes.Home.route, Icons.Rounded.Home
        ), NavBarItem(
            "MarketSpace", NavRoutes.MarketSpace.route, Icons.Rounded.Search
        ), NavBarItem(
            "Page3", NavRoutes.Page3.route, Icons.Rounded.Add
        ), NavBarItem(
            "Sell", NavRoutes.SellingScreen.route, Icons.Rounded.Sell
        ), NavBarItem(
            "Page5", NavRoutes.Page5.route, Icons.Rounded.Person
        )
    )

    var selectedDestination: NavBarItem by remember {
        mutableStateOf(listOfNavBarItems[0])
    }
    val windowSize = with(LocalDensity.current) {
        currentWindowSize().toSize().toDpSize()
    }
    val layoutType = if (windowSize.width >= 1200.dp) {
        NavigationSuiteType.NavigationDrawer
    } else {
        NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(
            currentWindowAdaptiveInfo()
        )
    }

    NavigationSuiteScaffold(layoutType = layoutType,
        navigationSuiteItems = {
            listOfNavBarItems.forEach {
                item(
                    selected = it == selectedDestination,
                    onClick = {
                        selectedDestination=it
                        navController1.navigate(it.route){
                            popUpTo(navController1.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop=true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = it.title
                        )
                    },
                    label = {
                        Text(text = it.title)
                    },
                )
            }
        }
    ) {
        NavHost(
            navController = navController1,
            startDestination = NavRoutes.Home.route
        ) {
            composable(NavRoutes.Home.route) {
                HomeScreen()
            }
            composable(NavRoutes.MarketSpace.route) {
                MarketSpace()
            }
            composable(NavRoutes.Page3.route) {
                Page3Screen()
            }
            composable(NavRoutes.SellingScreen.route) {
                SellingScreen()
            }
            composable(NavRoutes.Page5.route) {
                Page5Screen()
            }
        }
    }
}