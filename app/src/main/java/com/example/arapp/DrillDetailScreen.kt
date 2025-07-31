package com.example.arapp

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrillDetailScreen(drillName:String,navController: NavController) {
    val context = LocalContext.current

    val drillInfo = when (drillName) {
        "Concrete Core Drill" -> Triple(R.drawable.concrete_core_drill,
            "Used for drilling large diameter holes into concrete and masonry. Ideal for HVAC, plumbing, and electrical installations.",
            "Tap flat surface to place Drill 1."
        )
        "Rotary Hammer Drill" -> Triple(R.drawable.rotary_hammer_drill,
            "High-powered drill designed for heavy-duty tasks like chiseling and drilling into concrete, stone, or brick.",
            "Move closer to place accurately."
        )
        "Impact Percussion Drill" -> Triple(R.drawable.impact_percussion,
            "Compact yet powerful drill for light concrete work, ideal for precision in woodworking and small construction jobs.",
            "Ensure enough space before placing."
        )
        else -> Triple(R.drawable.concrete_core_drill,
            "Used for drilling large diameter holes into concrete and masonry. Ideal for HVAC, plumbing, and electrical installations.",
            "Tap flat surface to place Drill 1."
        )
    }

    val (imageResId, description, tips) = drillInfo

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(drillName,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)},
                colors = TopAppBarDefaults.topAppBarColors(Color.Blue),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))

            Text(drillName, fontSize = 24.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Image(painter = painterResource(id = imageResId), contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Description:", fontSize = 18.sp,fontWeight = FontWeight.Bold)

            Text(description, fontSize = 16.sp)

            Spacer(modifier = Modifier.height(12.dp))

            Text("Tips:", fontSize = 18.sp,fontWeight = FontWeight.Bold)

            Text(tips, fontSize = 16.sp)

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val intent = Intent(context, ArActivity::class.java)
                    val color = when (drillName) {
                        "Concrete Core Drill" -> android.graphics.Color.RED
                        "Rotary Hammer Drill" -> android.graphics.Color.GREEN
                        "Impact Percussion Drill" -> android.graphics.Color.BLUE
                        else -> android.graphics.Color.YELLOW
                    }
                    intent.putExtra("color", color)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start AR Drill", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
