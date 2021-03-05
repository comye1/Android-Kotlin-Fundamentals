package com.example.safeargs.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.safeargs.R
import com.example.safeargs.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    
    private lateinit var binding : FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_start,
            container,
            false
        )

        binding.button.setOnClickListener {view ->
            if(checkName()){
                var name = binding.editText.text.toString()
                view.findNavController()
                    .navigate(StartFragmentDirections.actionStartFragmentToPicFragment(name))
            }
        }

        return binding.root
    }


    private fun checkName() : Boolean{
        //이름이 빈 문자열인지 확인하기
        return binding.editText.text.isNullOrBlank()
    }
}