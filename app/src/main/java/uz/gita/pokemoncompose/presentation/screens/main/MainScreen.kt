package uz.gita.pokemoncompose.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.pokemoncompose.ui.theme.PokemonComposeTheme

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {

    }
}

@Composable
private fun MainContent(
//    val
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

    }
}

@Composable
@Preview(showBackground = true)
private fun MainContentPreview() {
    PokemonComposeTheme {
        MainContent()
    }
}