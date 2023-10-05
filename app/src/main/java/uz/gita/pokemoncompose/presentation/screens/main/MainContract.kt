package uz.gita.pokemoncompose.presentation.screens.main

import kotlinx.coroutines.flow.StateFlow

interface MainContract {
    interface ViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }

    data class UIState(
        val mainData: List<String> = listOf(),
    )

    interface Intent {
        data class ClickItem(
            val item: String,
        ) : Intent
    }
}