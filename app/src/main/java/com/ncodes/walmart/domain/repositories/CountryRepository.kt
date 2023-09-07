package com.ncodes.walmart.domain.repositories

import com.ncodes.walmart.domain.models.Country
import com.ncodes.walmart.utils.Result

interface CountryRepository {
   suspend fun getCountryInfo() : Result<List<Country?>>
}