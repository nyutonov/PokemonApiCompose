package uz.gita.pokemoncompose.presentation.screens.detail

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import uz.gita.pokemoncompose.domain.repository.MainRepository
import uz.gita.pokemoncompose.domain.usecase.MainUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: MainUseCase
) : DetailContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow(DetailContract.UIState())

    override fun onEventDispatcher(intent: DetailContract.Intent) {
        when (intent) {
            is DetailContract.Intent.SetCategory -> {
                uiState.update { it.copy(category = intent.category) }
            }

            DetailContract.Intent.GetAll -> {
                useCase.getCategoryData(uiState.value.category)
                    .onStart { uiState.update { it.copy(isProgress = true) } }
                    .onEach {
                        it.onSuccess { data ->
                            uiState.update { it.copy(data = data, isProgress = false, isShow = false) }
                        }

                        it.onFailure {
                            uiState.update { it.copy(isProgress = false, isShow = true) }
                        }
                    }
                    .launchIn(viewModelScope)
            }
        }
    }
}