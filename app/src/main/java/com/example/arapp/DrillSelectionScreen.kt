package com.example.arapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrillSelectionScreen(navController: NavController) {
    val drills = listOf("Concrete Core Drill", "Rotary Hammer Drill", "Impact Percussion Drill")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Drill Selection",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)},
                colors = TopAppBarDefaults.topAppBarColors(Color.Blue)
            )
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Select a Drill", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))

            drills.forEach { drill ->
                Button(
                    onClick = { navController.navigate("drilldetailscreen/$drill") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Text(drill)
                }
            }
        }
    }
}
