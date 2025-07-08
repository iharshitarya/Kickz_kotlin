package com.example.kickz_kotlin.userauthentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kickz_kotlin.ui.theme.KickzColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.TextStyle
import com.example.kickz_kotlin.utils.CommonTextField

@Composable
fun SignInWithEmail() {

    var email by remember { mutableStateOf("") }

    Box(Modifier.fillMaxSize())
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "KICKZ",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = KickzColors.BackgroundBlack
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .height(5.dp)
                .width(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            KickzColors.GradientLineBlue, KickzColors.GradientLineOrange
                        )
                    ), shape = RoundedCornerShape(5.dp)
                )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(12.dp),
                    ambientColor = KickzColors.Black,
                    spotColor = KickzColors.Black
                ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Welcome Back",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = KickzColors.Black
                )
                Text(
                    "Sign in to your account",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = KickzColors.Gray500
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Email",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = KickzColors.Black
                )

                CommonTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholderText = "Enter your email",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}