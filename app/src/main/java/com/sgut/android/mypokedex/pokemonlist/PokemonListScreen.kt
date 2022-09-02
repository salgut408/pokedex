package com.sgut.android.mypokedex.pokemonlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sgut.android.mypokedex.R
import com.sgut.android.mypokedex.data.models.PokedexListEntry
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun PokemonListScreen (
    navController: NavController
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))


            Image(painter = painterResource(id = R.drawable.pokelogo),
                    contentDescription = "Pokemon",
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
            )



            SearchBar(
                hint = "search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            PokemonList(navController = navController)
            
        }

    }
}




@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier

                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
//                .onFocusChanged {
//                    isHintDisplayed = it != FocusState.isFocused
//                }
        )
        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun PokemonList(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemonList by remember {viewModel.pokemonList}
    val endReached by remember {viewModel.endReached}
    val loadError by remember {viewModel.loadError}
    val isLoading by remember {viewModel.isLoading}

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = if(pokemonList.size%2==0) {
            pokemonList.size/2
        } else {
            pokemonList.size / 2+1
        }
        items(itemCount) {
            if(it>=itemCount-1&&!endReached) {
                viewModel.loadPokemonPaginated()
            }
            PokedexRow(rowIndex = it, entries = pokemonList, navController = navController)
        }
    }
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if(loadError.isNotEmpty()) {
                viewModel.loadPokemonPaginated()
        }
    }

}


@Composable
fun PokedexEntry(
    entry: PokedexListEntry,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel()

){
    val defaultDominatColor = MaterialTheme.colors.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominatColor)
    }

    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor,
                        defaultDominatColor
                    )
                )
            )
            .clickable {
                navController.navigate(
                    "pokemon_detail_screen/${dominantColor.toArgb()}/${entry.pokemonName}"
                )
            }
    ) {
        Column() {
//
//    CoilImage (
//        request = ImageRequest.Builder(LocalContext.current)
//            .data(entry.imgUrl)
//            .target {
//                viewModel.calcDominantColor(it) { color ->
//                    dominantColor = color
//                }
//            }
//            .build()
//            )


//            CoilImage(
//              imageRequest =  ImageRequest.Builder(LocalContext.current)
//                    .data(entry.imgUrl)
//                    .crossfade(true)
//                    .target {
//                        viewModel.calcDominantColor(it) { color ->
//                            dominantColor = color
//                        }
//                    }
//                    .build(),
//                contentDescription = entry.pokemonName,
//                modifier = Modifier
//                    .size(120.dp)
//                    .align(CenterHorizontally)
//
//
//            )

                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.scale(0.5f)
                )

            Text(
                text = entry.pokemonName,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()


            )
//            CoilImage(
//                imageRequest =
//                    ImageRequest.Builder(LocalContext.current)
//                        .data(entry.imgUrl)
//                        .crossfade(true)
//                        .build()
//
//
//
//            )

//                val painter = remember

//            val painter = rememberImagePainter(
//                data = entry.imageUrl,
//                builder = {
//                    crossfade(true)
//                    transformations(
//                        object : Transformation {
//                            override fun key(): String {
//                                return entry.imageUrl
//                            }
//
//                            override suspend fun transform(
//                                pool: BitmapPool,
//                                input: Bitmap,
//                                size: Size
//                            ): Bitmap {
//                                pokemonListViewModel.calcDominantColorBmp(input) { color ->
//                                    dominantColor = color
//                                }
//                                return input
//                            }
//
//                        }
//                    )
//                }
//            )
//            val painterState = painter.state
//            if (painterState is ImagePainter.State.Loading) {
//                CircularProgressIndicator(
//                    color = colors.primary,
//                    modifier = Modifier
//                        .size(120.dp)
//                        .scale(0.5f)
//                        .align(CenterHorizontally)
//                )
//            }
//            Image(
//                painter = painter,
//                contentDescription = entry.pokemonName,
//                modifier = Modifier
//                    .size(120.dp)
//                    .align(CenterHorizontally)
//            )




        }
    }

}

@Composable
fun PokedexRow(
    rowIndex: Int,
    entries: List<PokedexListEntry>,
    navController: NavController
    
) {
    Column() {
        Row() {
            PokedexEntry(entry = entries[rowIndex *2 ],
                navController =navController,
                modifier = Modifier.weight(1f)
            )
            
        }
        Spacer(modifier = Modifier.width(16.dp))
        if(entries.size >= rowIndex *2 + 2) {
            PokedexEntry(entry = entries[rowIndex *2 +1],
                navController =navController,
                modifier = Modifier.weight(1f)
            )

        } else  {
            Spacer(modifier = Modifier.weight(1f))
        }
        
    }
    Spacer(modifier = Modifier.height(16.dp))

}