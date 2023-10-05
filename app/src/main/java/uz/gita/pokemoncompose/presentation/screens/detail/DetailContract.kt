package uz.gita.pokemoncompose.presentation.screens.detail

import kotlinx.coroutines.flow.StateFlow
import uz.gita.pokemoncompose.domain.modules.MainModel

interface DetailContract {
    interface ViewModel {
        val uiState: StateFlow<UIState>

        fun onEventDispatcher(intent: Intent)
    }

    interface Intent {
        data class SetCategory(
            val category: String
        ) : Intent

        object GetAll : Intent
    }

    data class UIState(
        val data: List<MainModel> = listOf(),
        val category: String = "",
        val isProgress: Boolean = true,
        val isShow: Boolean = false
    )
}