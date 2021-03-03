package com.example.sharingfeature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sharingfeature.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonShare.setOnClickListener {
            shareText(binding.editText.text.toString())
        }
    }

    private fun shareText(text:String){
        startActivity(getShareIntent(text))
    }

    private fun getShareIntent(text: String):Intent{
        val shareIntent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, text)

        return shareIntent
    }
}