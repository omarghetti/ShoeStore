package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailsBinding
import com.example.shoestore.viewmodels.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        val shoeListViewModel: ShoeListViewModel by activityViewModels()
        binding.shoeListViewModel = shoeListViewModel
        binding.setLifecycleOwner { viewLifecycleOwner.lifecycle }

        binding.buttonSaveShoe.setOnClickListener {
            shoeListViewModel.addShoe()
            navigateBack()
        }
        return binding.root
    }

    private fun navigateBack() {
        val shoeListAction = ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment()
        this.findNavController().navigate(shoeListAction)
    }

}