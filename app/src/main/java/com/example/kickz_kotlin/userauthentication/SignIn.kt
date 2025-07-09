package com.example.kickz_kotlin.userauthentication

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kickz_kotlin.navigation.Screen
import com.example.kickz_kotlin.ui.theme.CommonTextStyles
import com.example.kickz_kotlin.ui.theme.KickzColors
import com.example.kickz_kotlin.utils.CommonBackground
import com.example.kickz_kotlin.utils.CommonTextField
import com.example.kickz_kotlin.utils.VerticalSpacer

@Composable
fun SignIn(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    var isInputFocused by remember { mutableStateOf(false) }

    val context = LocalContext.current

    BackHandler(enabled = isInputFocused) {
        focusManager.clearFocus()
    }

    CommonBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {
                    focusManager.clearFocus()
                },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.padding(bottom = 30.dp)
                ) {
                    Text(
                        text = "KICKZ",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = KickzColors.White
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
                }
                Card(
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = KickzColors.White.copy(alpha = 0.2f),
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Welcome Back", style = CommonTextStyles.heading)
                        Text("Sign in to your account", style = CommonTextStyles.subheading)
                    }
                    VerticalSpacer(20.dp)
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .fillMaxWidth(),
                    ) {
                        Text("Email", style = CommonTextStyles.textInputFieldHeading)
                        VerticalSpacer(3.dp)
                        CommonTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholderText = "Enter your email",
                            borderColor = KickzColors.Gray300,
                            placeholderColor = KickzColors.Gray500,
                            modifier = Modifier.onFocusChanged { focusState ->
                                isInputFocused = focusState.isFocused
                            })
                        VerticalSpacer(10.dp)
                        Text("Password", style = CommonTextStyles.textInputFieldHeading)
                        VerticalSpacer(3.dp)
                        CommonTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholderText = "Enter your password",
                            borderColor = KickzColors.Gray300,
                            placeholderColor = KickzColors.Gray500,
                            modifier = Modifier.onFocusChanged { focusState ->
                                isInputFocused = focusState.isFocused
                            })
                    }
                    VerticalSpacer(20.dp)
                    Button(
                        onClick = {
                            handleSignIn(
                                email = email, password = password, context = context
                            )
                        },
                        enabled = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .height(46.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = KickzColors.BackgroundBlack
                        )
                    ) {
                        Text("Sign In")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Don't have an account? ", color = KickzColors.White, fontSize = 12.sp
                        )
                        Text(
                            "Sign Up",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = Color(0xFF2563EB),
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.SignUp.route)
                            })
                    }
                    VerticalSpacer(10.dp)
                }
            }
        }
    }
}

fun handleSignIn(
    email: String, password: String, context: Context
) {
    if (email.isBlank() || password.isBlank()) {
        Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        return
    }
    Toast.makeText(context, "Sign In successful!", Toast.LENGTH_SHORT).show()
}
