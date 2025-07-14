package com.example.deep_linking

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {

        composable("home") {
            HomeScreen(navController)
        }

        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            ),
            deepLinks = listOf(
                navDeepLink { uriPattern = "https://pl-coding.com/detail/{id}" }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            DetailScreen(id)
        }
    }
}
