package com.zezzi.navigationcompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zezzi.navigationcompose.R
import com.zezzi.navigationcompose.ui.detail.view.Detail
import com.zezzi.navigationcompose.ui.events.view.EventGrid
import com.zezzi.navigationcompose.ui.profile.view.Profile
import com.zezzi.navigationcompose.ui.recepies.view.MainScreen


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier) {
        composable(route = NavigationState.Home.route) {
            EventGrid(
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                navController = navController
            )
        }
        composable(route = NavigationState.Detail.route) {
            Detail(navController = navController)
        }
        composable(route = NavigationState.Events.route) {
            MainScreen(navController = navController)
        }
        composable(route = NavigationState.Profile.route) {
            Profile(navController = navController)
        }
    }
}