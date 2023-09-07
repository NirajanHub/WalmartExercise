package com.ncodes.walmart.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ncodes.walmart.data.repository.CountryRepositoryImpl
import com.ncodes.walmart.data.repository.FakeCountryRepository
import com.ncodes.walmart.domain.models.Country
import com.ncodes.walmart.utils.Result
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    //Used to check edge cases and null values.
    private val countryRepo = FakeCountryRepository()

    //private val countryRepo = CountryRepositoryImpl()


    private val _liveData = MutableLiveData<Result<List<Country?>>>()
    val liveData = _liveData

    init {
        getCountries()
    }

    private fun getCountries(
    ){
        viewModelScope.launch {
            try{
                val data = countryRepo.getCountryInfo()
                _liveData.value = data
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}