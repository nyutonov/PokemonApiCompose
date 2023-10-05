package uz.gita.pokemoncompose.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.pokemoncompose.presentation.components.Item
import uz.gita.pokemoncompose.ui.theme.PokemonComposeTheme

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: MainContract.ViewModel = getViewModel<MainViewModel>()

        MainContent(uiState = viewModel.uiState.collectAsState())
    }
}

@Composable
private fun MainContent(
    uiState: State<MainContract.UIState>,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(uiState.value.mainData) {
                Item(it)
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
private fun MainContentPreview() {
    PokemonComposeTheme {
        MainContent(mutableStateOf(MainContract.UIState(listOf())))
    }
}