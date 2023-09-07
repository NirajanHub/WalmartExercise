package com.ncodes.walmart.data.remote

import com.ncodes.walmart.domain.models.Country
import com.ncodes.walmart.utils.StringConst
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {

    @GET(StringConst.countryUrl)
    suspend fun getInfo(): Response<List<Country?>>

}