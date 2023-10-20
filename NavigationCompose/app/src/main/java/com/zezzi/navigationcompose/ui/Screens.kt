package com.zezzi.navigationcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventTabScreen() {
    Column {
        Text(
            text = "Events Screen test",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(start = 106.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ProfileTabScreen() {
    Column {
        Text(
            text = "Profile Screen test",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(start = 106.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun BooksTabScreen() {
    Column {
        Text(
            text = "Books Screen test",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(start = 106.dp)
                .fillMaxWidth()
        )
    }
}