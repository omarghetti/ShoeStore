package com.example.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    val name = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val desc = MutableLiveData<String>()



    fun addShoe() {
        val newShoe = Shoe(name.value!!,size.value!!.toDouble(),company.value!!,desc.value!!)
        _shoeList.value?.add(newShoe)
        resetForm()
    }

    private fun resetForm() {
        name.value = ""
        company.value = ""
        size.value = ""
        desc.value = ""
    }

    init {
        Timber.i("ShoeList ViewModel Initialized")
        _shoeList.value = mutableListOf(
            Shoe(name = "Nike Air Max", size = 10.5, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike Air Force 1", size = 10.0, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike React", size = 11.0, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike Tiempo R9", size = 9.5, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike UpTempo", size = 8.5, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike Classic", size = 7.5, company = "Nike", description = "New Shoes")
        )
        size.value = ""
    }
}