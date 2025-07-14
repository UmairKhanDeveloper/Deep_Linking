package com.example.deep_linking

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    val id = 100
    val deepLinkUrl = "https://pl-coding.com/detail/$id"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen")
        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            Toast.makeText(context, "Deep link: $deepLinkUrl", Toast.LENGTH_SHORT).show()
            navController.navigate("detail/$id")
        }) {
            Text("Go to Detail Screen")
        }

        Spacer(Modifier.height(16.dp))
        Text("Deep link: $deepLinkUrl")
    }
}
