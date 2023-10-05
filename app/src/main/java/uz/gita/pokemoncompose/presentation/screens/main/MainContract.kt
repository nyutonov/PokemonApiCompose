package uz.gita.pokemoncompose.presentation.screens.main

import kotlinx.coroutines.flow.StateFlow
import retrofit2.http.GET
import retrofit2.http.Path

interface MainContract {
    interface ViewModel {
        val uiState: StateFlow<UIState>

        fun onEventDispatcher(intent: Intent)
    }

    data class UIState(
        val mainData: List<String> = listOf()
    )

    interface Intent {

    }

    interface Direction {
        suspend fun openDetailScreen()
    }
}