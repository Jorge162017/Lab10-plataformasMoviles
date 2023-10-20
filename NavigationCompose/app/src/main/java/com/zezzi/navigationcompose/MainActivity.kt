package com.zezzi.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zezzi.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Navigation()
                    //TabNavigation()
                    //BottomTabNavigation()
                }
            }
        }
    }
}

@Composable
fun RowBetween() {
    Row(modifier = Modifier.height(56.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("Hello World!")
        Spacer(Modifier.weight(0.5f).fillMaxHeight().background(Color.Red))
        Text("Hello World!2")
        Spacer(Modifier.weight(4f).fillMaxHeight().background(Color.Green))
        Icon(painter = painterResource(id = R.drawable.ic_music), contentDescription = "")
    }
}

@Composable
fun MyUI() {
    Column() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.3f)) {
            Image(
                painterResource(R.drawable.background),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.align(Alignment.Center)) {
                Image(
                    painterResource(R.drawable.profileimage),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(150.dp, 150.dp)
                )
                Text("Hello, Jetpack Compose")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationComposeTheme {
        RowBetween()
    }
}