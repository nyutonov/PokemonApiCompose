package uz.gita.pokemoncompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.pokemoncompose.data.repository.MainRepositoryImpl
import uz.gita.pokemoncompose.domain.repository.MainRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindAppRepository(impl: MainRepositoryImpl): MainRepository
}