package com.zezzi.navigationcompose.navigation

import androidx.compose.runtime.Composable
import com.zezzi.navigationcompose.R
import com.zezzi.navigationcompose.ui.BooksTabScreen
import com.zezzi.navigationcompose.ui.EventTabScreen
import com.zezzi.navigationcompose.ui.ProfileTabScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object Events : TabItem(R.drawable.ic_music, "Events", { EventTabScreen() })
    object Profile : TabItem(R.drawable.ic_movie, "Profile", { ProfileTabScreen() })
    object Books : TabItem(R.drawable.ic_book, "Books", { BooksTabScreen() })
}