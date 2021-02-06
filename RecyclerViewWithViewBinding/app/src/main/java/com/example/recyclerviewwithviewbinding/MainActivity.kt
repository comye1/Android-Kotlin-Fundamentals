package com.example.recyclerviewwithviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter:PlayerAdapter
    private var playerList:ArrayList<Player> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playerList.add(Player("박병호", "52", 1986))
        playerList.add(Player("서건창", "14", 1989))
        playerList.add(Player("이정후", "51", 1998))
        playerList.add(Player("박준태", "23", 1991))
        playerList.add(Player("이지영", "56", 1986))
        playerList.add(Player("요키시", "43", 1989))
        playerList.add(Player("최원태", "20", 1997))
        playerList.add(Player("한현희", "63", 1993))

        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager

        adapter = PlayerAdapter(playerList)
        binding.recyclerView.adapter = adapter
    }
}