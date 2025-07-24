package com.example.kickz_kotlin.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kickz_kotlin.ui.theme.CommonTextStyles
import com.example.kickz_kotlin.ui.theme.KickzColors

@Composable
fun CommonHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = KickzColors.White)
            .padding(horizontal = 15.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "KICKZ",
            style = CommonTextStyles.heading,
            color = KickzColors.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
        )
        Row {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = KickzColors.Black,
                modifier = Modifier.clickable { })
            HorizontalSpacer(15.dp)
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = KickzColors.Black,
                modifier = Modifier.clickable { })
            HorizontalSpacer(15.dp)
            Box(
                contentAlignment = Alignment.TopEnd, modifier = Modifier.wrapContentSize()
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart",
                    tint = KickzColors.Black,
                    modifier = Modifier.clickable { /* handle click */ })
                Box(
                    modifier = Modifier
                        .offset(x = 5.dp, y = (-6).dp).size(16.dp)
                        .background(
                            color = KickzColors.Red500,
                            shape = androidx.compose.foundation.shape.CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "1",
                        fontSize = 10.sp,
                        color = KickzColors.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.offset(
                            y = -4.dp
                        )
                    )
                }
            }
        }
    }
}


