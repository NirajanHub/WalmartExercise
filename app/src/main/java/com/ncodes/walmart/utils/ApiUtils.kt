package com.ncodes.walmart.utils

import com.ncodes.walmart.data.remote.CountryApi

class ApiUtils {
    companion object {
         fun getCountryApi(): CountryApi {
            return RetrofitClient.retrofitClient(StringConst.BASE_URL).create(
                CountryApi::class.java
            )
        }
    }
}