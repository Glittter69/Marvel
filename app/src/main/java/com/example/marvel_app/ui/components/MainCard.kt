package com.example.marvel_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.marvel_app.R

@Composable
fun MainCard(
    imageUrl: String,
    name: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier.padding(horizontal = 10.dp)
            .size(330.dp,583.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {
        Box(contentAlignment = Alignment.BottomStart) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = name,
                fontFamily = FontFamily(Font(R.font.inter_28pt_extrabold)),
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    start = 28.dp,
                    bottom = 50.dp
                )
            )
        }
    }
}

@Preview
@Composable
fun MainCardPreview() {
    MainCard(
        imageUrl = "",
        name = "Hero",
        onClick = { }
    )
}
