package com.zezzi.navigationcompose.ui.events.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zezzi.navigationcompose.R
import com.zezzi.navigationcompose.navigation.AppBar
import com.zezzi.navigationcompose.navigation.NavigationState
import com.zezzi.navigationcompose.ui.events.model.Event
import com.zezzi.navigationcompose.ui.theme.NavigationComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventGrid(modifier: Modifier = Modifier, navController: NavController) {
    val events = listOf(
        Event("tets", 4),
        Event("tets", 4),
        Event("tets", 4),
        Event("tets", 4)
    )
    Scaffold(topBar = {
        AppBar(title = "Events Grid", navController = navController)
    }) {
        Column(modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.Start) {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
                    modifier = Modifier.padding(16.dp)
                ) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Text(
                            "This Favorites",
                            Modifier
                                .border(1.dp, Color.Gray)
                                .height(80.dp)
                                .wrapContentSize()
                        )
                    }
                    items(events) { topic ->
                        EventCard(topic, navController = navController)
                    }
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Text(
                            "All Concerts",
                            Modifier
                                .border(1.dp, Color.Gray)
                                .height(80.dp)
                                .wrapContentSize()
                        )
                    }
                    items(events) { topic ->
                        EventCard(event = topic, navController = navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCard(event: Event, modifier: Modifier = Modifier, navController: NavController) {
    Card(onClick = { navController.navigate(NavigationState.Detail.route) }) {
        Row {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = event.name,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = event.availableSeats.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventPreview() {
    NavigationComposeTheme {
        EventGrid(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
            navController = rememberNavController()
        )
    }
}