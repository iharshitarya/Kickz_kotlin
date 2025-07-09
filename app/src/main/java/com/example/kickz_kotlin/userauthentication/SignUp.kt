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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.kickz_kotlin.ui.theme.KickzColors
import androidx.navigation.NavHostController
import com.example.kickz_kotlin.ui.theme.CommonTextStyles
import com.example.kickz_kotlin.utils.CommonBackground
import com.example.kickz_kotlin.utils.CommonTextField
import com.example.kickz_kotlin.utils.VerticalSpacer

@Composable
fun SignUp(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    var isInputFocused by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    val context = LocalContext.current

    BackHandler(enabled = isInputFocused) {
        focusManager.clearFocus()
    }

    CommonBackground { }

    Box(Modifier.fillMaxSize())
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(scrollState)  // Scroll the entire content
            .padding(vertical =  30.dp)
            .fillMaxSize()
            .clickable(
                indication = null, interactionSource = remember { MutableInteractionSource() }) {
                focusManager.clearFocus()
            }) {
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
        Spacer(modifier = Modifier.height(5.dp))
        Card(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 15.dp)
//                .verticalScroll(scrollState),
            , colors = CardDefaults.cardColors(
                containerColor = KickzColors.White.copy(alpha = 0.2f),
            ), shape = RoundedCornerShape(14.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create Account", style = CommonTextStyles.heading)
                Text("Join the KICKZ community", style = CommonTextStyles.subheading)
            }
            VerticalSpacer(15.dp)
            Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
                Text("Full Name", style = CommonTextStyles.textInputFieldHeading)
                VerticalSpacer(3.dp)
                CommonTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholderText = "Enter your full name",
                    borderColor = KickzColors.Gray300,
                    placeholderColor = KickzColors.Gray500,
                    modifier = Modifier.onFocusChanged { focusState ->
                        isInputFocused = focusState.isFocused
                    })
                VerticalSpacer(10.dp)
                Text("Phone Number", style = CommonTextStyles.textInputFieldHeading)
                VerticalSpacer(3.dp)
                CommonTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    placeholderText = "Enter your mobil number",
                    borderColor = KickzColors.Gray300,
                    placeholderColor = KickzColors.Gray500,
                    modifier = Modifier.onFocusChanged { focusState ->
                        isInputFocused = focusState.isFocused
                    })
                VerticalSpacer(10.dp)
                Text("Email", style = CommonTextStyles.textInputFieldHeading)
                VerticalSpacer(3.dp)
                CommonTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholderText = "Enter your email",
                    borderColor = KickzColors.Gray300,
                    placeholderColor = KickzColors.Gray500
                )
                VerticalSpacer(10.dp)
                Text("Password", style = CommonTextStyles.textInputFieldHeading)
                VerticalSpacer(3.dp)
                CommonTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholderText = "Create a password",
                    borderColor = KickzColors.Gray300,
                    placeholderColor = KickzColors.Gray500
                )
                VerticalSpacer(10.dp)
                Text("Confirm Password", style = CommonTextStyles.textInputFieldHeading)
                VerticalSpacer(3.dp)
                CommonTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholderText = "Confirm your password",
                    borderColor = KickzColors.Gray300,
                    placeholderColor = KickzColors.Gray500
                )
            }
            VerticalSpacer(10.dp)
            Button(
                onClick = {
                    handleSignUpClick(
                        name = name,
                        phoneNumber = phoneNumber,
                        email = email,
                        password = password,
                        confirmPassword = confirmPassword,
                        context = context
                    )
                },
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .height(46.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = KickzColors.BackgroundBlack
                )
            ) {
                Text("Create Account")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Already have an account? ", color = KickzColors.White, fontSize = 12.sp
                )
                Text(
                    "Sign in",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFF2563EB),
                    modifier = Modifier.clickable {
                        navController.navigate("SignIn")
                    })
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
        VerticalSpacer(30.dp)
    }

}

fun handleSignUpClick(
    name: String,
    phoneNumber: String,
    email: String,
    password: String,
    confirmPassword: String,
    context: Context
) {
    if (name.isBlank() || phoneNumber.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
        Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        return
    } else if (password != confirmPassword) {
        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
        return
    }

}
