package com.example.kickz_kotlin.screens.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kickz_kotlin.Kickz
import com.example.kickz_kotlin.ui.theme.CommonTextStyles
import com.example.kickz_kotlin.ui.theme.KickzColors
import com.example.kickz_kotlin.utils.HorizontalSpacer
import com.example.kickz_kotlin.utils.VerticalSpacer

@Composable
fun HomepageBanner(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF232b43),
                        Color(0xFF020305),
                        Color(0xFF251814)                    )
                )
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Step Into",
                style = CommonTextStyles.heading,
                color = KickzColors.White,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize
            )
            HorizontalSpacer(8.dp)
            Text(
                text = "Tomorrow",
                style = CommonTextStyles.heading.copy(
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            KickzColors.GradientLineBlue, KickzColors.GradientLineOrange
                        )
                    )
                ),
            )
        }
        Text(
            "Discover the latest collection of premium sneakers that blend style, comfort, and innovation.",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = KickzColors.White
        )

        VerticalSpacer(20.dp)

        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 15.dp
                ), shape = RoundedCornerShape(8.dp), colors = ButtonDefaults.buttonColors(
                containerColor = KickzColors.White
            )
        ) {
            Text(
                "Shop Now",
                color = KickzColors.Black,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 40.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xFF353e56),
                                Color(0xFF3b3a43),
                                Color(0xFF3e3432),
                                Color(0xFF423026),
                            )
                        ), shape = RoundedCornerShape(14.dp)
                    )
                    .padding(20.dp),

                ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF353e56),
                                    Color(0xFF3b3a43),
                                    Color(0xFF3e3432),
                                    Color(0xFF423026),
                                )
                            ), shape = RoundedCornerShape(14.dp)
                        )
                        .padding(20.dp), contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Hello")
                        Text(
                            "Featured Collection",
                            color = KickzColors.White,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }


    }
}