package com.zezzi.navigationcompose.navigation.bottomtabs

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomTabNavigation() {
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(BottomNavigationScreens.Events,
        BottomNavigationScreens.Books,
        BottomNavigationScreens.Profile)
    val pagerState = rememberPagerState { bottomNavigationItems.count() }
    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        MainConfigurationNavigation(navController)
    }
}

