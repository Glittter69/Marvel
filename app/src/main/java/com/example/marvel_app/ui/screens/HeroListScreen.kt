package com.example.marvel_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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


@Composable
fun HeroListScreen(navController: NavController) {

    val lazyListState = rememberLazyListState()
    val snapFlingBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_main_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .padding(top = 45.dp, bottom = 57.dp, start = 30.dp, end = 30.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://iili.io/JMnuvbp.png"),
                contentDescription = "Marvel Logo",
                modifier = Modifier
                    .padding(bottom = 54.dp)
                    .size(128.dp, 27.dp)
            )
            Text(
                text = stringResource(R.string.header),
                color = Color.White,
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.inter_28pt_extrabold)),
                modifier = Modifier.padding(bottom = 82.dp)
            )

            LazyRow(
                state = lazyListState,
                flingBehavior = snapFlingBehavior,
                modifier = Modifier.fillMaxWidth()
            ) {
                items(heroes) { hero ->
                    Card(
                        modifier = Modifier
                            .clickable {
                                navController.navigate("hero_details/${hero.name}")
                            }
                            .padding(horizontal = 10.dp)
                            .size(330.dp,583.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Box(contentAlignment = Alignment.BottomStart) {
                            Image(
                                painter = rememberAsyncImagePainter(hero.image),
                                contentScale = ContentScale.FillBounds,
                                contentDescription = stringResource(hero.name),
                                modifier = Modifier.fillMaxSize()
                            )
                            Text(
                                text = stringResource(hero.name),
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
            }
        }
    }
}