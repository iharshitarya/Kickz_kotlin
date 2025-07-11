package com.example.kickz_kotlin.screens.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kickz_kotlin.utils.VerticalSpacer
import com.example.kickz_kotlin.viewmodel.CategoryListViewModel

@Composable
fun HomepageCategory(
    modifier: Modifier = Modifier,
    viewModel: CategoryListViewModel = hiltViewModel()
) {
    val categories by viewModel.categories.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Shop by Category",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.ExtraBold
        )
        VerticalSpacer(20.dp)
        Text(
            text = "Find your perfect pair for every occasion",
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFF555E6C)
        )
        VerticalSpacer(20.dp)

        when {
            isLoading -> {
                Text("Loading...", color = Color.Gray)
            }

            error != null -> {
                Text("Error: $error", color = Color.Red)
            }

            else -> {
                LazyColumn {
                    items(categories.size) { index ->
                        val category = categories[index]
                        Text(
                            text = category.name, // Adjust this if your model has a different property
                            modifier = Modifier.padding(16.dp),
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
