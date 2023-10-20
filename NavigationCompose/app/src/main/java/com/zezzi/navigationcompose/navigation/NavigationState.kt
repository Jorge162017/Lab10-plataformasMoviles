package com.zezzi.navigationcompose.navigation

sealed class NavigationState(val route: String) {
    object Home: NavigationState("Home")
    object Events: NavigationState("Event")
    object Detail: NavigationState("Detail")
    object Profile: NavigationState("Profile")
    object Settings: NavigationState("Settings")
}