package com.fiap.quemeosortudo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NamesAdapter(val names: MutableList<String>) : RecyclerView.Adapter<NamesAdapter.NameViewHolder>() {

    class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView by lazy {
            view.findViewById<TextView>(R.id.tvName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_name, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.tvName.text = names[position]
    }

}