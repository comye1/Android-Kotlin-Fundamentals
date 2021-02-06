package com.example.recyclerviewwithviewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithviewbinding.databinding.PlayerItemBinding

class PlayerAdapter(private val items : ArrayList<Player>) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    //Custom ViewHolder - view 자리에 binding.root 전달하여 생성
    class ViewHolder(val binding : PlayerItemBinding): RecyclerView.ViewHolder(binding.root)

    //Create a ViewHolder Instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding) // with the binding
    }

    //ViewHolder의 멤버 binding 을 통해 레이아웃 요소에 접근
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvName.text = items[position].name
        holder.binding.tvNumber.text = items[position].number
        holder.binding.tvYear.text = items[position].birthYear.toString()
    }

    override fun getItemCount(): Int = items.size
}