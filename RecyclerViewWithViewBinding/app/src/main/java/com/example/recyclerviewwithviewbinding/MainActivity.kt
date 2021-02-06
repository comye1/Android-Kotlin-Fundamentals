package com.example.recyclerviewwithviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //1. LayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager
    //2. Adapter
    private lateinit var adapter:PlayerAdapter
    //3. Data List
    private var playerList:ArrayList<Player> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adding Data
        playerList.add(Player("박병호", "52", 1986))
        playerList.add(Player("서건창", "14", 1989))
        playerList.add(Player("이정후", "51", 1998))
        playerList.add(Player("박준태", "23", 1991))
        playerList.add(Player("이지영", "56", 1986))
        playerList.add(Player("요키시", "43", 1989))
        playerList.add(Player("최원태", "20", 1997))
        playerList.add(Player("한현희", "63", 1993))

        //LayoutManager from the context
        linearLayoutManager = LinearLayoutManager(this)
        //Set LayoutManager to the binding's RecyclerView
        binding.recyclerView.layoutManager = linearLayoutManager
        //Set adapter with a custom adapter and data list
        adapter = PlayerAdapter(playerList)
        //Set adapter to the binding's Recyclerview
        binding.recyclerView.adapter = adapter
    }
}