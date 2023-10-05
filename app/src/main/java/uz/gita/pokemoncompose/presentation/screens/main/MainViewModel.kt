package uz.gita.pokemoncompose.presentation.screens.mainimport androidx.lifecycle.ViewModelimport androidx.lifecycle.viewModelScopeimport dagger.hilt.android.lifecycle.HiltViewModelimport kotlinx.coroutines.flow.MutableStateFlowimport kotlinx.coroutines.flow.launchInimport kotlinx.coroutines.flow.onEachimport kotlinx.coroutines.flow.updateimport kotlinx.coroutines.launchimport uz.gita.pokemoncompose.domain.repository.MainRepositoryimport uz.gita.pokemoncompose.domain.usecase.MainUseCaseimport javax.inject.Inject@HiltViewModelclass MainViewModel @Inject constructor(    private val useCase: MainUseCase,    private val direction: MainDirection) : MainContract.ViewModel, ViewModel() {    override val uiState = MutableStateFlow(MainContract.UIState())    init {        useCase.getCategories()            .onEach {                it.onSuccess { data ->                    uiState.update { it.copy(mainData = data) }                }                it.onFailure {                    //....                }            }            .launchIn(viewModelScope)    }    override fun onEventDispatcher(intent: MainContract.Intent) {        when (intent) {            is MainContract.Intent.ClickItem -> {                viewModelScope.launch { direction.moveToDetail(intent.item) }            }        }    }}