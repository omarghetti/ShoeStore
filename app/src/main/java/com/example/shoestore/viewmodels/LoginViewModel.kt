package com.example.shoestore.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Login
import timber.log.Timber

class LoginViewModel : ViewModel() {
    private var _loggedUser = MutableLiveData<Login>()
    val loggedUser: LiveData<Login>
        get() = _loggedUser

    private var _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn

    fun onLogin(user: String, pass: String) {
        if(user != "" && pass != "") {
            _loggedUser.value = Login(user,pass)
            _isLoggedIn.value = true
        }
    }

    init {
        Timber.i("viewModel initialized")
    }
}