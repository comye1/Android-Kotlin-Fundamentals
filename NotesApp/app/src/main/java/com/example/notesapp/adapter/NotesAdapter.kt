package com.example.notesapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.databinding.ItemRvNotesBinding
import com.example.notesapp.entities.Notes

class NotesAdapter() : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    var listener:OnItemClickListener?=null
    var arrList = ArrayList<Notes>()

    class NotesViewHolder(val binding:ItemRvNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(arrNotesList:List<Notes>){
        arrList = arrNotesList as ArrayList<Notes>
    }

    fun setOnClickListener(listener1 : OnItemClickListener){
        listener = listener1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
//        return NotesViewHolder(
//                LayoutInflater.from(parent.context).inflate(R.layout.item_rv_notes, parent, false)
//        )
        val binding = ItemRvNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        holder.binding.tvTitle.text = arrList[position].title
        holder.binding.tvDesc.text = arrList[position].noteText
        holder.binding.tvDateTime.text = arrList[position].dateTime

        if(arrList[position].color != null){
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor(arrList[position].color))
        }else{
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor(R.color.lightBlack.toString()))
        }
        holder.binding.cardView.setOnClickListener {
            listener!!.onClicked(arrList[position].id!!)
        }
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    interface OnItemClickListener{
        fun onClicked(noteId:Int)
    }

}