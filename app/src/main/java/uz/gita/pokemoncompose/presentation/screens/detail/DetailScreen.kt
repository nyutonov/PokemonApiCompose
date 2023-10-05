package uz.gita.pokemoncompose.presentation.screens.detailimport android.annotation.SuppressLintimport androidx.compose.foundation.layout.fillMaxSizeimport androidx.compose.foundation.lazy.LazyColumnimport androidx.compose.foundation.lazy.itemsimport androidx.compose.material3.Surfaceimport androidx.compose.runtime.Composableimport androidx.compose.runtime.collectAsStateimport androidx.compose.ui.Modifierimport androidx.compose.ui.tooling.preview.Previewimport cafe.adriel.voyager.androidx.AndroidScreenimport cafe.adriel.voyager.hilt.getViewModelimport uz.gita.pokemoncompose.presentation.components.Itemimport uz.gita.pokemoncompose.ui.theme.PokemonComposeThemeclass DetailScreen(private val category: String) : AndroidScreen() {    @Composable    override fun Content() {        val viewModel: DetailContract.ViewModel = getViewModel<DetailViewModel>()        MainContent(viewModel.uiState.collectAsState().value)    }}@Composableprivate fun MainContent(    uiState: DetailContract.UIState = DetailContract.UIState(),) {    Surface(modifier = Modifier.fillMaxSize()) {        LazyColumn {            items(uiState.data) {                Item(it.name)            }        }    }}@SuppressLint("UnrememberedMutableState")@Composable@Preview(showBackground = true)private fun MainContentPreview() {    PokemonComposeTheme {        MainContent()    }}