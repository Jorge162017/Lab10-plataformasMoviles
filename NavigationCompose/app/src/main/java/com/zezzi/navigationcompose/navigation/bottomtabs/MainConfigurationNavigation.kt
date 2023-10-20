package com.zezzi.navigationcompose.navigation.bottomtabs

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zezzi.navigationcompose.R
import com.zezzi.navigationcompose.navigation.NavigationState
import com.zezzi.navigationcompose.ui.detail.view.Detail
import com.zezzi.navigationcompose.ui.events.view.EventGrid
import com.zezzi.navigationcompose.ui.profile.view.Profile
import com.zezzi.navigationcompose.ui.recepies.view.MainScreen

@Composable
fun MainConfigurationNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route) {
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