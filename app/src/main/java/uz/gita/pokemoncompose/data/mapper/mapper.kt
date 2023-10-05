package uz.gita.pokemoncompose.data.mapper

import uz.gita.pokemoncompose.data.source.remote.response.Result
import uz.gita.pokemoncompose.domain.modules.MainModel

fun Result.toData(): MainModel = MainModel(
    data = this
)