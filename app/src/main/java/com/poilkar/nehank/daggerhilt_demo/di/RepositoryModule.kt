package com.poilkar.nehank.daggerhilt_demo.di

import com.poilkar.nehank.daggerhilt_demo.app.MyApp_HiltComponents
import com.poilkar.nehank.daggerhilt_demo.network.ApiService
import com.poilkar.nehank.daggerhilt_demo.repo.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun providesDataRepo(apiService: ApiService) : DataRepository{
        return DataRepository(apiService)
    }
}