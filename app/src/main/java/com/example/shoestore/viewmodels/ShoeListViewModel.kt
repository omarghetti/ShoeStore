package com.example.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }

    init {
        _shoeList.value = mutableListOf(
            Shoe(name = "Nike Air Max", size = 10.5, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike Air Force 1", size = 10.0, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike React", size = 11.0, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike Tiempo R9", size = 9.5, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike UpTempo", size = 8.5, company = "Nike", description = "New Shoes"),
            Shoe(name = "Nike Classic", size = 7.5, company = "Nike", description = "New Shoes")
        )
    }
}