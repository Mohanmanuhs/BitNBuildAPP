package com.example.bnbproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bnbproject.R
import com.example.bnbproject.navigation.NavRoutes
import com.example.bnbproject.ui.theme.txtColor
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo"
            )
            Text(
                text = "My Closest",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp, color = txtColor
            )
        }
    }

    LaunchedEffect(key1 = true) {
        delay(200)
        if(FirebaseAuth.getInstance().currentUser!=null) {
            navController.navigate(NavRoutes.BottomNav.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop=true
            }
        }else {
            navController.navigate(NavRoutes.Login.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop=true
            }
        }
    }
}