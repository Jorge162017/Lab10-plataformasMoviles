package com.zezzi.navigationcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zezzi.navigationcompose.R

@ExperimentalMaterial3Api
@Composable
fun AppBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(text = title)
                },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                run {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null)
                    }
                }
            } else {
                null
            }
        })
}