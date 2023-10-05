    package uz.gita.pokemoncompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun Item(
    text: String = "ergergr",
    onClick: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .clickable { onClick.invoke(text) }
            .padding(10.dp)
    ) {
        Card(
            modifier = Modifier
                .height(36.dp)
                .align(Alignment.CenterVertically)
                .width(36.dp),
            shape = RoundedCornerShape(60.dp)
        ) {

        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            text = text
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MainPreview() {
    PokemonComposeTheme {
        Item()
    }
}