package com.poilkar.nehank.daggerhilt_demo.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.poilkar.nehank.daggerhilt_demo.model.ResultData
import com.poilkar.nehank.daggerhilt_demo.model.SeriesModel
import com.poilkar.nehank.daggerhilt_demo.usecase.DataUseCase
import kotlinx.coroutines.CoroutineScope

class MainActivityViewModel @ViewModelInject constructor(private val dataUseCase: DataUseCase): ViewModel() {

    fun getRepositoryList(): LiveData<ResultData<SeriesModel>> {
        return liveData<ResultData<SeriesModel>> {
            emit(ResultData.Loading())
            emit(dataUseCase.getRepositoryList())
        }
    }
}