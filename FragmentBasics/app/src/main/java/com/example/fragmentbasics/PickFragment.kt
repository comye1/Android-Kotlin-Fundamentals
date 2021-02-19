package com.example.fragmentbasics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fragmentbasics.databinding.FragmentPickBinding

class PickFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPickBinding>(
            inflater, R.layout.fragment_pick, container, false)

        // navigate conditionally
        binding.apply {
            pickBtn.setOnClickListener { view ->
                if(catRbtn.isChecked){
                    view.findNavController().navigate(R.id.action_pickFragment_to_catFragment)
                }else if(dogRbtn.isChecked){
                    view.findNavController().navigate(R.id.action_pickFragment_to_dogFragment)
                }else{
                    Toast.makeText(requireContext(), "Pick One!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }

}