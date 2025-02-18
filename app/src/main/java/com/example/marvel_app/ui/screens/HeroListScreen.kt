package com.example.marvel_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.marvel_app.presentation.MainViewModel
import com.example.marvel_app.R
import com.example.marvel_app.data.Superhero
import com.example.marvel_app.presentation.MainState
import com.example.marvel_app.ui.HeroDetailScreen
import com.example.marvel_app.ui.components.MainCard

@Composable
fun HeroListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val viewModel = viewModel<MainViewModel>()
    val state by viewModel.stateFlow.collectAsState()
    when (val currentState = state) {
        is MainState.Loading -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is MainState.Error -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = stringResource(R.string.error))
            }
        }
        is MainState.Success -> {
            HeroListContent(
                modifier = modifier,
                navController = navController,
                superheroes = currentState.superheroes,
            )
        }
    }
}

@Composable
private fun HeroListContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    superheroes: List<Superhero>,
) {
    val lazyListState = rememberLazyListState()
    Column(
        modifier = modifier
            .paint(
                painter = painterResource(id = R.drawable.ic_main_background),
                contentScale = ContentScale.Crop
            )
            .padding(top = 45.dp, bottom = 57.dp, start = 30.dp, end = 30.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://iili.io/JMnuvbp.png"),
            contentDescription = stringResource(R.string.marvel_studios),
            modifier = Modifier
                .padding(bottom = 54.dp)
                .size(128.dp, 27.dp)
        )
        Text(
            text = stringResource(R.string.choose_hero),
            color = Color.White,
            fontSize = 28.sp,
            fontFamily = FontFamily(Font(R.font.inter_28pt_extrabold)),
            modifier = Modifier.padding(bottom = 82.dp)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(24.dp),
            state = lazyListState,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState),
        ) {
            items(superheroes) { hero ->
                MainCard(
                    imageUrl = hero.imageUrl,
                    name = hero.name,
                    onClick = {
                        navController.navigateToHeroDetailScreen(hero.id)
                    },
                )
            }
        }
    }
}

private fun NavController.navigateToHeroDetailScreen(id: String) {
    navigate(HeroDetailScreen.withHeroId(id))
}

@Preview
@Composable
fun HeroListScreenPreview() {
    HeroListScreen(navController = rememberNavController())
}