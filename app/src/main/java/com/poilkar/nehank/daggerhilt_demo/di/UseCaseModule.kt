package com.poilkar.nehank.daggerhilt_demo.di

import com.poilkar.nehank.daggerhilt_demo.repo.DataRepository
import com.poilkar.nehank.daggerhilt_demo.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {
    @Provides
    fun providesUseCase(dataRepository: DataRepository): DataUseCase{
        return DataUseCase(dataRepository)
    }

}