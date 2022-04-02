package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding
import com.example.shoestore.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private lateinit var loginViewModel : LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.loginViewModel = loginViewModel
        binding.setLifecycleOwner { viewLifecycleOwner.lifecycle }

        loginViewModel.isLoggedIn.observe(viewLifecycleOwner, Observer { loggedIn ->
            if(loggedIn) {
                login()
            }
        })

        binding.button.setOnClickListener { submitForm(binding.editTextTextEmailAddress2.text.toString(), binding.editTextStringPassword.text.toString()) }
        binding.button2.setOnClickListener { submitForm(binding.editTextTextEmailAddress2.text.toString(), binding.editTextStringPassword.text.toString()) }
        return binding.root
    }

    private fun login() {
        Toast.makeText(context, "Hello ${loginViewModel.loggedUser.value?.userName}", Toast.LENGTH_SHORT).show()
        val loginAction = LoginFragmentDirections.actionLoginFragment2ToWelcomeFragment()
        this.findNavController().navigate(loginAction)
    }

    private fun submitForm(user: String, pass: String) {
            loginViewModel.onLogin(user, pass)
    }

}