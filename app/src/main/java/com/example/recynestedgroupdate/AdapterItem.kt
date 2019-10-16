package com.example.recynestedgroupdate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterItem(val Datane: ArrayList<ModelNya>): RecyclerView.Adapter<AdapterItem.ViewHolder>() {

        override fun onBindViewHolder(holder: AdapterItem.ViewHolder, position: Int) {
        val location = Datane[position]
        holder.tvName?.text = location.name
        holder.tvHobi?.text = location.hobi

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterItem.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Datane.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvHobi = itemView.findViewById<TextView>(R.id.tvHobi)
    }
}