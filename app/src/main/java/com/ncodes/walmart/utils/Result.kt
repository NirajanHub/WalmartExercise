package com.ncodes.walmart.utils

class Result<out T>(val status: Status, val data: T?, val error: Error?, val message: String?, val statusCode: Int) {

    enum class Status{
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object{
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS,data,null, null,200)
        }
        fun <T> error(message: String?,statusCode: Int): Result<T> {
            return  Result(Status.ERROR,null,Error(),message, statusCode = statusCode)
        }
        fun <T> loading(): Result<T> {
            return  Result(Status.LOADING,null,null,null, 200)
        }
    }
}