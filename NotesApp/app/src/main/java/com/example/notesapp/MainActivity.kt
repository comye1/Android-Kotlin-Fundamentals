package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
//        setContentView(R.layout.activity_main)
        setContentView(view)
        replaceFragment(HomeFragment.newInstance(),true)
    }

    fun replaceFragment(fragment: Fragment, isTransition:Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()

        if(isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
        }

        fragmentTransition.replace(R.id.frameLayout,fragment).addToBackStack(fragment.javaClass.simpleName)

    }
}