package com.example.safeargs.screens

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.safeargs.R
import com.example.safeargs.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    lateinit var binding : FragmentResultBinding

    val args : ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)

        binding.imagePet.setImageURI(Uri.parse(args.imgPath))
        binding.textPetName.text = args.petName

        return binding.root
    }


}