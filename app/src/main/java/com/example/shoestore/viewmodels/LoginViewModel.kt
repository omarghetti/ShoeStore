package com.example.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Login

class LoginViewModel : ViewModel() {

    private var _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private var _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private var _loggedUser = MutableLiveData<Login>()
    val loggedUser: LiveData<Login>
        get() = _loggedUser

    private var _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn

    fun onLogin() {
        _loggedUser.value = Login(_username.value, _password.value)
        _isLoggedIn.value = true
    }
}