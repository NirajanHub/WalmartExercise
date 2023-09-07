package com.ncodes.walmart.data.repository

import com.ncodes.walmart.data.remote.CountryApi
import com.ncodes.walmart.domain.models.Country
import com.ncodes.walmart.domain.repositories.CountryRepository
import com.ncodes.walmart.utils.ApiUtils
import com.ncodes.walmart.utils.Result
import retrofit2.Response

class CountryRepositoryImpl : CountryRepository  {
    override suspend fun getCountryInfo(): Result<List<Country?>> {
       return getResponse {
           ApiUtils.getCountryApi().getInfo()
       }
    }

    private suspend fun getResponse(request: suspend () -> Response<List<Country?>>?): Result<List<Country?>> {
        return try {
            val result = request.invoke()
            Result.success(result?.body())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.error(e.message, 400)
        }
    }
}