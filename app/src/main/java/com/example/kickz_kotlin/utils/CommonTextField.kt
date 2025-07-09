package com.example.kickz_kotlin.utils

import androidx.compose.material3.Surface // ✅ Compose Surface with elevation support
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kickz_kotlin.ui.theme.CommonTextStyles
import com.example.kickz_kotlin.ui.theme.KickzColors

@Composable
fun CommonTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String = "",
    modifier: Modifier = Modifier,
    borderColor: Color = KickzColors.Gray300,
    placeholderColor: Color = KickzColors.Gray500
) {

    val focusManager = LocalFocusManager.current
    Surface(
        shadowElevation = 10.dp, // 👈 Elevation here
        shape = RoundedCornerShape(4.dp)
    ) {
        Box(
            modifier = modifier
                .height(46.dp)
                .fillMaxWidth()
//                .border(1.dp, borderColor, RoundedCornerShape(4.dp))
//                .background(KickzColors.White, RoundedCornerShape(4.dp))
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (value.isEmpty()) {
                Text(
                    text = placeholderText,
                    color = placeholderColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(
                    color = KickzColors.Black,
                    fontSize = 14.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            )
        }
    }
}
