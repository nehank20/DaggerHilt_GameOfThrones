package com.poilkar.nehank.daggerhilt_demo.network

import com.poilkar.nehank.daggerhilt_demo.model.SeriesModel
import retrofit2.http.GET

interface ApiService {

    @GET("singlesearch/shows?q=game-of-thrones&embed=episodes")
    suspend fun getSeriesData() : SeriesModel
}