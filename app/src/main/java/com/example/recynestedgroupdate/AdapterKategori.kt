package com.example.recynestedgroupdate

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class AdapterKategori(val Datane: ArrayList<ModelNya>): RecyclerView.Adapter<AdapterKategori.ViewHolder>() {

    val byAddress = Datane.groupBy { it.address }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: AdapterKategori.ViewHolder, position: Int) {
        Log.i("apaan sih", byAddress.toString());

        // Update date label
        val dateList = byAddress.values.toMutableList()

        holder.tvHeader?.text = dateList[position][0].address.toString()
        // Create vertical Layout Manager
        holder.rvList?.layoutManager = LinearLayoutManager(holder.rvList.context, LinearLayout.VERTICAL, false)
        // Access RecyclerView Adapter and load the data

        var adapter = AdapterItem(dateList[position] as ArrayList<ModelNya>)
        holder.rvList?.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterKategori.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return byAddress.count()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvHeader = itemView.findViewById<TextView>(R.id.tvHeader)
        val rvList = itemView.findViewById<RecyclerView>(R.id.rvItem)
    }
}
