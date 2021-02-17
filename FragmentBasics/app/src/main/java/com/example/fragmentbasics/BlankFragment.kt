package com.example.fragmentbasics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fragmentbasics.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // inflate
        val binding = DataBindingUtil.inflate<FragmentBlankBinding>(inflater, R.layout.fragment_blank, container, false)

        // return view
        return binding.root
    }
}