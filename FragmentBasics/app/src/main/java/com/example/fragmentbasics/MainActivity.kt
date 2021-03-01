package com.example.fragmentbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fragmentbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout // null safety

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.navHostFragment)
        drawerLayout = binding.drawerLayout // initialize

//        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // drawer 버튼도 NavigateUp 동작에서 처리함!!
        Toast.makeText(this, "navigateUp", Toast.LENGTH_SHORT).show()
        val navController = this.findNavController(R.id.navHostFragment)
//        return navController.navigateUp()
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}