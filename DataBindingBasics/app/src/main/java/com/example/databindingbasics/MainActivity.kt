package com.example.databindingbasics

import android.content.Context
import android.icu.text.IDNA
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databindingbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val role: Role = Role("Rachel Green")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.role = role

//        findViewById<Button>(R.id.button).setOnClickListener {
//            setID(it)
//        }
        // (2)
        binding.button.setOnClickListener {
            setCast(it)
        }
    }

    private fun setCast(view: View){
//        val editText = findViewById<EditText>(R.id.edit)
//        val textView = findViewById<TextView>(R.id.text)
//
//        textView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        textView.visibility = View.VISIBLE

        //(3)
//        binding.textCast.text = binding.edit.text
//        binding.edit.visibility = View.GONE
//        binding.button.visibility = View.GONE
//        binding.textCast.visibility = View.VISIBLE

        binding.apply {
//            textCast.text = edit.text ==>
            role?.cast = edit.text.toString()
            invalidateAll() //refresh the UI with the new data

            edit.visibility = View.GONE
            button.visibility = View.GONE
            textCast.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}