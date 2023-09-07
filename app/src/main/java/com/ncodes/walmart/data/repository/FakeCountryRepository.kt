package com.ncodes.walmart.data.repository

import com.ncodes.walmart.domain.models.Country
import com.ncodes.walmart.domain.models.Currency
import com.ncodes.walmart.domain.models.Language
import com.ncodes.walmart.domain.repositories.CountryRepository
import com.ncodes.walmart.utils.Result

class FakeCountryRepository : CountryRepository {
    override suspend fun getCountryInfo(): Result<List<Country?>> {
         //return Result.loading()
        return Result.success(data = getList())
        //return Result.error(StringConst.errorMessage, 400)
    }

    private fun getList(): List<Country> {
        return emptyList()
    //        listOf(
//            Country(
//                "Kabul",
//                "AF",
//                Currency("AFN", "Afghan afghani", "؋"),
//                "https://restcountries.eu/data/afg.svg",
//                Language("ps", "Pashto"),
//                "Afghanistan",
//                "AS"
//            ),
//            Country(
//                "Mariehamn",
//                "AX",
//                Currency("EUR", "Euro", "€"),
//                "https://restcountries.eu/data/ala.svg",
//                Language("sv", "Swedish"),
//                "Åland Islands",
//                "EU"
//            ),
//            Country(
//                "Tirana",
//                "AL",
//                Currency("ALL", "Albanian lek", "L"),
//                "https://restcountries.eu/data/alb.svg",
//                Language("sq", "Albanian"),
//                "Albania",
//                "EU"
//            ),
//            Country(
//                "Algiers",
//                "DZ",
//                Currency("DZD", "Algerian dinar", "د.ج"),
//                "https://restcountries.eu/data/dza.svg",
//                Language("ar", "Arabic"),
//                "Algeria",
//                "AF"
//            )
//        )
    }

}