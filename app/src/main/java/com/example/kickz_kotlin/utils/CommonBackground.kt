package com.example.kickz_kotlin.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.kickz_kotlin.ui.theme.KickzColors

@Composable
fun CommonBackground(content: @Composable () -> Unit) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val width = this.constraints.maxWidth.toFloat()
        val height = this.constraints.maxHeight.toFloat()

        // Layer 1: Black base
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        )

        // Layer 2: Vertical gradient
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

        // Layer 3: Radial Blue glow
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

        // Layer 4: Radial Orange glow
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

        // The content passed to the background
        content()
    }
}
