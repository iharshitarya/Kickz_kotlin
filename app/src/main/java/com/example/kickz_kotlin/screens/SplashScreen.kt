package com.example.kickz_kotlin.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kickz_kotlin.ui.theme.KickzColors
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.Dp

@Composable
fun SplashScreen() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val width = this.constraints.maxWidth.toFloat()
        val height = this.constraints.maxHeight.toFloat()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            KickzColors.GradientBlue20,
                            KickzColors.GradientOrange20
                        )
                    )
                )
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(KickzColors.GradientBlue20, Color.Transparent),
                        center = Offset(width * 0.3f, height * 0.2f),
                        radius = width * 0.3f
                    )
                )
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(KickzColors.GradientOrange20, Color.Transparent),
                        center = Offset(width * 0.65f, height * 0.8f),
                        radius = width * 0.3f
                    )
                )
        )

        // 🌟 Main content (title + loader)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "KICKZ",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = KickzColors.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .width(100.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                KickzColors.GradientLineBlue,
                                KickzColors.GradientLineOrange
                            )
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
            )
            Text(
                modifier = Modifier.padding(top = 14.dp),
                text = "Step into the future",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = KickzColors.Gray300
            )
            Spacer(modifier = Modifier.height(16.dp))
            LoadingDots()
        }
    }
}

@Composable
fun LoadingDots() {

    val transition = rememberInfiniteTransition(label = "dots")

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        for (i in 0 until 3) {
            val scale by transition.animateFloat(
                initialValue = 0.6f, targetValue = 1.2f, animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 500, easing = FastOutSlowInEasing
                    ),
                    repeatMode = RepeatMode.Reverse,
                    initialStartOffset = StartOffset(i * 150) // stagger the start time
                ), label = "dotScale_$i"
            )
            val color = if (i == 1) KickzColors.LoadingDotOrange else KickzColors.LoadingDotBlue
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .scale(scale) // 🔥 apply the animation here
                    .background(color = color, shape = CircleShape)
            )

        }
    }
}
