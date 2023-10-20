package com.zezzi.navigationcompose.ui.recepies.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zezzi.navigationcompose.ui.recepies.view.model.CardItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController = rememberNavController()) {
    var recipeContent by remember { mutableStateOf("") }
    var urlContent by remember { mutableStateOf("") }
    var cardList = remember { mutableStateListOf<CardItem>()  }
    var context = LocalContext.current

    Column(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center) {
        OutlinedTextField(
            value = recipeContent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = PaddingValues(horizontal = 16.dp)),
            onValueChange = { recipeContent = it },
            label = { Text("Receta") }
        )

        OutlinedTextField(
            value = urlContent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onValueChange = { urlContent = it },
            label = { Text("Url") }
        )

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            if (recipeContent.isNotEmpty() && urlContent.isNotEmpty()) {
                cardList.add(CardItem(recipeContent, urlContent))
                recipeContent = ""
                urlContent = ""
            }
        } ) {
            Text(text = "Add Content")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(cardList) { cardItem ->
                CardRow(cardItem = cardItem)
            }
        }
    }
}

@Composable
fun CardRow(cardItem: CardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clip(RoundedCornerShape(10.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = cardItem.image,
                contentDescription = null,
                modifier = Modifier
                    .width(55.dp)
                    .height(55.dp)
            )
            Text(
                text = cardItem.recipe,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}
