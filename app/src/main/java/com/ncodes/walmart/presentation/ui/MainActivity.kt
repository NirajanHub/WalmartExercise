package com.ncodes.walmart.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ncodes.walmart.databinding.MainBinding
import com.ncodes.walmart.domain.models.Country
import com.ncodes.walmart.presentation.viewModel.CountryViewModel
import com.ncodes.walmart.utils.Result
import com.ncodes.walmart.utils.StringConst


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainBinding
    private lateinit var recyclerView: RecyclerView
            private val  viewModel : CountryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        val view = binding.root
        recyclerView = binding.recyclerView
        setContentView(view)
        loadData()

    }

    private fun loadData(){
        viewModel.liveData.observe(this){
            when(it.status){
                 Result.Status.SUCCESS ->{
                     binding.progressIndicator.visibility = View.GONE
                     recyclerView.visibility = View.VISIBLE
                     if(!it.data.isNullOrEmpty()){
                         instantiateRecyclerView(it.data)
                     }else {
                         showToast(StringConst.errorMessage)
                     }
                 }
                Result.Status.LOADING -> {
                    binding.progressIndicator.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Result.Status.ERROR -> {
                    binding.progressIndicator.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                    showToast(it.message)
                }
            }
        }
    }

    private fun instantiateRecyclerView(countryList: List<Country?>){

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter(countryList = countryList)
        recyclerView.adapter = adapter
    }

    fun showToast(message:String?){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
