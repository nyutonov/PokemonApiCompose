package uz.gita.pokemoncompose.presentation.screens.detail

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import uz.gita.pokemoncompose.domain.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val appRepository: MainRepository
) : DetailContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow(DetailContract.UIState())

    init {
        appRepository.getCategoryData(uiState.value.category)
            .onEach {
                it.onSuccess { data ->
                    uiState.update { it.copy(data = data) }
                }

                it.onFailure {
                    //...
                }
            }
    }

    override fun onEventDispatcher(intent: DetailContract.Intent) {
        when (intent) {
            is DetailContract.Intent.SetCategory -> {
                uiState.update { it.copy(category = intent.category) }
            }
        }
    }
}