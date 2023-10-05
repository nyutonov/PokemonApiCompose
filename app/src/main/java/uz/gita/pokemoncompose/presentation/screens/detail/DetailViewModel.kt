package uz.gita.pokemoncompose.presentation.screens.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import uz.gita.pokemoncompose.domain.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val appRepository: MainRepository
) : DetailContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow(DetailContract.UIState())

    init {

    }

    override fun onEventDispatcher(intent: DetailContract.Intent) {

    }
}