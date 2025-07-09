package com.example.kickz_kotlin.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object CommonTextStyles {
    val heading = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = KickzColors.White
    )

    val subheading = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        color = Color.Gray
    )

    val textInputFieldHeading = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = KickzColors.White
    )
    val textInputFieldSubText= TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = KickzColors.Black
    )
}