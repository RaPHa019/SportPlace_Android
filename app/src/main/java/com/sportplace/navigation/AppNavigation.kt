package com.sportplace.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sportplace.views.mapAddLocationPlace.MapAddLocationPlace
import com.sportplace.views.mapListPlaces.MapListPlacesScreen

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "mapListPlaces"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable("mapListPlaces") { MapListPlacesScreen(navController) }
        composable("mapAppLocationPlace") { MapAddLocationPlace(navController) }
    }
}
