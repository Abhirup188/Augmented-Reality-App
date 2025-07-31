package com.example.arapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navController: NavHostController){
    NavHost(startDestination = Screen.DrillSelectionScreen.route, navController = navController){
        composable(Screen.DrillSelectionScreen.route){
            DrillSelectionScreen(navController)
        }
        composable(Screen.DrillDetailScreen.route+"/{drillName}") {backStackEntry ->
            val drillName = backStackEntry.arguments?.getString("drillName")
            requireNotNull(drillName) { "Drill name is required" }
            DrillDetailScreen(drillName,navController)
        }
    }
}