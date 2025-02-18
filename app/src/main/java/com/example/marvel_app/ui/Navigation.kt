package com.example.marvel_app.ui

import androidx.compose.animation.scaleIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.marvel_app.ui.HeroDetailScreen.HERO_ID
import com.example.marvel_app.ui.screens.HeroDetailScreen
import com.example.marvel_app.ui.screens.HeroListScreen

object HeroListScreen {

    fun route(): String {
        return "main"
    }
}

object HeroDetailScreen {

    const val HERO_ID = "id"

    fun route(): String {
        return "hero?$HERO_ID={$HERO_ID}"
    }

    fun withHeroId(id: String): String {
        return "hero?$HERO_ID=$id"
    }
}

@Composable
fun MarvelApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HeroListScreen.route(),
        enterTransition = { scaleIn() },
    ) {
        composable(HeroListScreen.route()) {
            HeroListScreen(navController = navController)
        }
        composable(
            route = HeroDetailScreen.route(),
            arguments = listOf(
                navArgument(HERO_ID) { type = NavType.StringType },
            )
        ) { backStackEntry ->
            HeroDetailScreen(
                navController = navController,
                heroId = backStackEntry.arguments?.getString(HERO_ID)
                    ?: error("No value passed for $HERO_ID"),
            )
        }
    }
}
