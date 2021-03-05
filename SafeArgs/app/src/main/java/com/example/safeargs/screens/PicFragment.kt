package com.example.safeargs.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.safeargs.R
import com.example.safeargs.databinding.FragmentPicBinding

class PicFragment : Fragment() {

    private lateinit var binding : FragmentPicBinding

    // get Args
    val args: PicFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pic,
            container,
            false
        )
        //set textView with petName from args
        binding.petNameTextView.text = args.petName

        return binding.root
    }
}