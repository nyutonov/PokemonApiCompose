package uz.gita.pokemoncompose.data.repository

import android.util.Log
import androidx.compose.ui.text.capitalize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.pokemoncompose.data.mapper.toData
import uz.gita.pokemoncompose.data.source.remote.api.MainApi
import uz.gita.pokemoncompose.data.source.remote.response.MainResponse
import uz.gita.pokemoncompose.domain.modules.MainModel
import uz.gita.pokemoncompose.domain.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val api: MainApi
) : MainRepository {
    override fun getCategories(): Flow<Result<List<String>>> = flow {
        val list = arrayListOf<String>()

        for (prop in MainResponse::class.members) {
            var name = prop.name

            if (!name.contains("component") && name != "copy" && name != "equals" && name != "hashCode" && name != "toString") {
                name = name.replace("_", " ").capitalize()
                list.add(name)
            }

            emit(Result.success(list))
        }
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)

    override fun getCategoryData(category: String): Flow<Result<List<MainModel>>> = flow {
        val response = api.getDataByCategory(category)

        if (response.isSuccessful && response.body() != null) {
            emit(Result.success(response.body()!!.results.map { it.toData() }))
        } else {
            //...
        }
    }
        .catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)
}