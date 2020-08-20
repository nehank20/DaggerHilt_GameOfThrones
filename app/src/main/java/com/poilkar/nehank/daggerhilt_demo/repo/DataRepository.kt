package com.poilkar.nehank.daggerhilt_demo.repo

import com.poilkar.nehank.daggerhilt_demo.model.SeriesModel
import com.poilkar.nehank.daggerhilt_demo.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getSeriesData(): SeriesModel {
        return apiService.getSeriesData()
    }
}