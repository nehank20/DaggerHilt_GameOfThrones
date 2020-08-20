package com.poilkar.nehank.daggerhilt_demo.model

sealed class ResultData<out T> {
    data class Success<out T>(val data: T? = null) : ResultData<T>()
    data class Loading(val nothing: Nothing? = null) : ResultData<Nothing>()
    data class Failure(val message: String? = null) : ResultData<Nothing>()
    data class Exception(val message: String? = null) : ResultData<Nothing>()

}