package com.example.marvel_app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app.ui.screens.HeroDetailScreen
import com.example.marvel_app.ui.screens.HeroListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "hero_list") {
        composable("hero_list") { HeroListScreen(navController) }
        composable("hero_details/{heroName}") { backStackEntry ->
            val heroName = backStackEntry.arguments?.getString("heroName")?.toIntOrNull()
            HeroDetailScreen(navController, heroName)
        }
    }
}
