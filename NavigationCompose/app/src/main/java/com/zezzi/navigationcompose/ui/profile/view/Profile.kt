package com.zezzi.navigationcompose.ui.profile.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zezzi.navigationcompose.R
import com.zezzi.navigationcompose.navigation.AppBar
import com.zezzi.navigationcompose.navigation.NavigationState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController = rememberNavController()) {
    Scaffold(topBar = {
        AppBar(title = "Profile", navController = navController)
    }) {
        Column {
            Text(
                text = "Profile Event",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(start = 106.dp)
                    .fillMaxWidth()
            )
            Button(onClick = { navController.navigate(route = NavigationState.Events.route) }) {
                Text(text = "Start Events")
            }
        }
    }
}