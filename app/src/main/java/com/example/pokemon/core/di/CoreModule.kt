package com.example.pokemon.core.data.di

import com.example.pokemon.core.data.PokemonRepositoryImp
import com.example.pokemon.core.data.domain.repository.PokemonRepository
import com.example.pokemon.core.data.remote.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoreModule {

    @Provides
    @Singleton
    fun providerApi() : PokemonApi{
        val client = OkHttpClient.Builder()
            //.addInterceptor(ApiKeyInterceptor())
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
        return Retrofit.Builder().baseUrl(PokemonApi.BASE_URL).
        addConverterFactory(MoshiConverterFactory.create()).
        client(client).build().create()
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: PokemonApi
    ): PokemonRepository {
        return PokemonRepositoryImp(api)
    }
}