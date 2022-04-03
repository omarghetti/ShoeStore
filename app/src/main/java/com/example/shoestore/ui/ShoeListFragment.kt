package com.example.shoestore.ui

import android.os.Bundle
import android.util.AttributeSet
import android.view.*
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.viewmodels.ShoeListViewModel
import org.w3c.dom.Text

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        val shoeListViewModel: ShoeListViewModel by activityViewModels()

        binding.shoeListViewModel = shoeListViewModel
        binding.setLifecycleOwner { viewLifecycleOwner.lifecycle }

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEachIndexed { index,shoe ->
                val textView = TextView(context)
                textView.setText("${shoe.name}, Size: ${shoe.size}, Description: ${shoe.description}")
                binding.shoeListLinear.addView(textView,index)
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}