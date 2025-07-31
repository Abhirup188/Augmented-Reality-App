package com.example.arapp

sealed class Screen(val route:String) {
    object DrillSelectionScreen: Screen(route = "drillselectionscreen")
    object DrillDetailScreen: Screen("drilldetailscreen")
}