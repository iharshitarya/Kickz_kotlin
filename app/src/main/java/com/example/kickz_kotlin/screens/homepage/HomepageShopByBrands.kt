package com.example.kickz_kotlin.screens.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kickz_kotlin.R
import com.example.kickz_kotlin.ui.theme.KickzColors
import com.example.kickz_kotlin.utils.VerticalSpacer

@Composable
fun HomepageShopByBrands(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Shop by Brands",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.ExtraBold
        )
        VerticalSpacer(5.dp)
        Text(
            text = "Find your favourite brand pair for every occasion",
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFF555E6C)
        )
        VerticalSpacer(20.dp)
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(4) { index ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Card(
                        elevation = CardDefaults.cardElevation( // For Material3
                            defaultElevation = 5.dp
                        ),
                        colors = CardDefaults.cardColors(containerColor = KickzColors.White),
                        shape = RoundedCornerShape(70.dp)
                    ) {
//                        AsyncImage(
//                            model = "https://res.cloudinary.com/dh63bpbda/image/upload/v1752214865/iphbsisgdkt9izngjhdo.jpg",
//                            contentDescription = null,
//                            modifier = Modifier
//                                .size(80.dp)
//                                .clip(RoundedCornerShape(70.dp))
//                        )
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 35.dp),
                                modifier = Modifier.size(80.dp).border(
                                    color = KickzColors.White,
                                    width = 4.dp,
                                    shape = CircleShape
                                )
                                ,
                                colors = CardDefaults.cardColors(
                                    KickzColors.Black.copy(alpha = 0.9f)
                                )
                            ) {
                                val gradientBrush = Brush.linearGradient(
                                    colors = listOf(
                                        KickzColors.GradientBlue20, KickzColors.GradientOrange20
                                    )
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(brush = gradientBrush),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.adidas),
                                        contentDescription = null,
                                        modifier = Modifier.size(40.dp)
                                    )
                                }
                            }

                    }
                    Text(
                        text = "Brand",
                        modifier = Modifier.padding(vertical = 10.dp),
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        fontWeight = FontWeight.Medium
                    )
                }

            }
        }
    }
}