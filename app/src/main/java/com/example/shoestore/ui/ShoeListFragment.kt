package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.viewmodels.ShoeListViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        shoeListViewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        binding.shoeListViewModel = shoeListViewModel
        binding.setLifecycleOwner { viewLifecycleOwner.lifecycle }
        return binding.root
    }

}