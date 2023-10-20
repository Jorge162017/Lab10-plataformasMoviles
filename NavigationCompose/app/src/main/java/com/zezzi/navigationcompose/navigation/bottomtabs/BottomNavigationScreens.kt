package com.zezzi.navigationcompose.navigation.bottomtabs

import com.zezzi.navigationcompose.R
import com.zezzi.navigationcompose.navigation.NavigationState

sealed class BottomNavigationScreens(var icon: Int, var title: String, val route: String) {
    object Events : BottomNavigationScreens(R.drawable.ic_music, "Events", route = NavigationState.Home.route)
    object Profile : BottomNavigationScreens(R.drawable.ic_movie, "Profile", route = NavigationState.Profile.route)
    object Books : BottomNavigationScreens(R.drawable.ic_book, "Books", route = NavigationState.Detail.route)
}