package com.zezzi.eventzezziapp.ui.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import androidx.lifecycle.viewModelScope
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    val rememberedMeals: MutableState<List<MealResponse>> =
        remember { mutableStateOf(emptyList<MealResponse>()) }

    val isLoading: MutableState<Boolean> = remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        try {
            val response = viewModel.getMeals()
            rememberedMeals.value = response?.categories.orEmpty()
            isLoading.value = false
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            isLoading.value = false
        }
    }

    Scaffold(
        topBar = {
            AppBar(
                title = "RECETAS",
                navController = navController
            )
        }
    ) {
        if (isLoading.value) {
            // Muestra el indicador de carga si isLoading es true
            LoadingScreenMeals()
        } else {
            Column (modifier = Modifier.padding(it)){
                // Muestra la lista de botones si isLoading es false
                MealList(navController, rememberedMeals.value)
            }
        }
    }
}

@Composable
fun LoadingScreenMeals() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(207, 186, 240)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MealList(navController: NavController, meals: List<MealResponse>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(207, 186, 240))
            .verticalScroll(rememberScrollState())
    ) {
        meals.forEach { meal ->
            Button(
                onClick = {
                    navController.navigate("DishesCategoriesScreen/${meal.name}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 25.dp)
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(data = meal.imageUrl),
                        contentDescription = null,
                        modifier = Modifier.size(75.dp)
                    )
                    Text(
                        text = meal.name,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically),
                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}


