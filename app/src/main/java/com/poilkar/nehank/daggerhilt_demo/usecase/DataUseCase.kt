package com.poilkar.nehank.daggerhilt_demo.usecase

import com.poilkar.nehank.daggerhilt_demo.model.ResultData
import com.poilkar.nehank.daggerhilt_demo.model.SeriesModel
import com.poilkar.nehank.daggerhilt_demo.repo.DataRepository
import javax.inject.Inject

class DataUseCase @Inject constructor(private val dataRepository: DataRepository){
    suspend fun getRepositoryList(): ResultData<SeriesModel> {

        val seriesData = dataRepository.getSeriesData()
        val resultData = if(!seriesData.embedded.episodes.isNullOrEmpty()){
            ResultData.Success(seriesData)
        }else{
            ResultData.Failure("Something went wrong")
        }

        return resultData
    }
}