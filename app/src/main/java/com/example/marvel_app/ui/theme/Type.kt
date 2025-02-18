package com.example.marvel_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
    ),
    headlineMedium = TextStyle(
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
    )
)

