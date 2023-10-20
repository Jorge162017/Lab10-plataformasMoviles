package com.zezzi.navigationcompose.ui.detail.view

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zezzi.navigationcompose.R
import com.zezzi.navigationcompose.navigation.AppBar
import com.zezzi.navigationcompose.navigation.NavigationState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detail(navController: NavController) {
    Scaffold(topBar = {
        AppBar(title = "Detail", navController = navController)
    }) {
        Column(modifier = Modifier.fillMaxWidth()
            .padding(106.dp),
            horizontalAlignment = Alignment.End) {
            Column {
                Text(
                    text = "Detail Event",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                )
                Button(onClick = { navController.navigate(route = NavigationState.Profile.route) }) {
                    Text(text = "Test Navigation")
                }
            }
        }
    }

}