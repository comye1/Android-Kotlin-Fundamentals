package com.example.clickhandlerswithviewbinding

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.clickhandlerswithviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setListeners(binding)

    }

    private fun setListeners(binding: ActivityMainBinding){
        val clickableViews:List<View> =
            listOf(binding.redBtn, binding.orangeBtn, binding.yellowBtn,
            binding.greenBtn, binding.blueBtn, binding.navyBtn, binding.purpleBtn)

        for(item in clickableViews){
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View){
        when(view.id){
            R.id.red_btn -> view.setBackgroundColor(Color.RED)
            R.id.orange_btn -> view.setBackgroundColor(Color.rgb(255,133,0))
            R.id.yellow_btn -> view.setBackgroundColor(Color.YELLOW)
            R.id.green_btn -> view.setBackgroundColor(Color.GREEN)
            R.id.blue_btn -> view.setBackgroundColor(Color.BLUE)
            R.id.navy_btn -> view.setBackgroundColor(Color.rgb(0,0,128))
            R.id.purple_btn -> view.setBackgroundColor(Color.rgb(102, 49, 153))
        }
    }
}