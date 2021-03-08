package com.example.safeargs.screens

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

        binding.buttonSelect.setOnClickListener {
            pickImageGallery()
        }
        binding.buttonComplete.setOnClickListener {

        }

        return binding.root
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            binding.imageView.setImageURI(data?.data)
            binding.imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        }
    }

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }
}