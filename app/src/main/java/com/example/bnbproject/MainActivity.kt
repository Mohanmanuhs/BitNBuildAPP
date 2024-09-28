package com.example.bnbproject

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import com.example.bnbproject.navigation.NavGraphScreen
import com.example.bnbproject.ui.theme.BNBProjectTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BNBProjectTheme {
                val navController = rememberNavController()
                NavGraphScreen(navController = navController)
            }
        }
    }
}