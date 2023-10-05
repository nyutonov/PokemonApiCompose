package uz.gita.pokemoncompose.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun Item() {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {

    }
}

@Composable
@Preview(showBackground = true)
fun MainPreview() {
    PokemonComposeTheme {
        Item()
    }
}