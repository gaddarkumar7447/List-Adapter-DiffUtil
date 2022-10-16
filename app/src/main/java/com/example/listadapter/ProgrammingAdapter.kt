package com.example.listadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProgrammingAdapter : androidx.recyclerview.widget.ListAdapter<ProgrammingItem, ProgrammingAdapter.ViewModel> (DiffUtil()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        return ViewModel(view)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
       val item = getItem(position)
        holder.bind(item)
    }

    class ViewModel (view : View) : RecyclerView.ViewHolder(view){
        private val name: TextView = view.findViewById(R.id.name)
        private val id: TextView = view.findViewById(R.id.idO)
        fun bind(item: ProgrammingItem){
            name.text = item.name
            id.text = item.initial
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>(){
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgrammingItem,newItem: ProgrammingItem): Boolean {
            return oldItem == newItem
        }
    }

}