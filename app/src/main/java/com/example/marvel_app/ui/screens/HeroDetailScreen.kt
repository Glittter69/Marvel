package com.example.marvel_app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.marvel_app.R
import com.example.marvel_app.data.heroes

@SuppressLint("RestrictedApi")
@Composable
fun HeroDetailScreen(navController: NavController, heroName: Int?) {
    val hero = heroes.find { it.name == heroName }
    if (hero != null) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(hero.image),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = { navController.popBackStack() },
                    border = BorderStroke(0.dp, Color.Transparent),
                    modifier = Modifier.size(32.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_left),
                        contentDescription = "Back Button",
                        modifier = Modifier.size(32.dp),
                        tint = Color.White
                    )
                }


                Spacer(modifier = Modifier.height(676.dp))

                Text(
                    text = stringResource(hero.name),
                    fontFamily = FontFamily(Font(R.font.inter_28pt_extrabold)),
                    fontSize = 38.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(hero.description),
                    fontFamily = FontFamily(Font(R.font.inter_28pt_bold)),
                    fontSize = 26.sp,
                    lineHeight = 36.sp,
                    color = Color.White,
                )
            }
        }
    }
}
