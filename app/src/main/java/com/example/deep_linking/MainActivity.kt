package com.example.deep_linking

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.TaskStackBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.deep_linking.ui.theme.Deep_LinkingTheme
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Deep_LinkingTheme {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            "https://wa.me/923014210047".toUri()
                        )
                        val pendingIntent = TaskStackBuilder.create(applicationContext).run {
                            addNextIntentWithParentStack(intent)
                            getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                            )
                        }
                        pendingIntent.send()

                    }) {
                        Text(text = "whattsApp DeepLink")
                    }

                    Button(onClick = {
                        val intent = Intent(
                        Intent.ACTION_VIEW,
                        "https://facebook.com".toUri()
                    )
                        val pendingIntent = TaskStackBuilder.create(applicationContext).run {
                            addNextIntentWithParentStack(intent)
                            getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                            )
                        }
                        pendingIntent.send()

                    }) {
                        Text(text = "Google DeepLink ")
                    }

                }


            }
        }
    }
}

