package com.example.firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(var list:ArrayList<DatabaseModel>) :RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
     var name:TextView=itemView.findViewById(R.id.txt_name)
        var email:TextView=itemView.findViewById(R.id.txt_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_list,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=list[position].name
        holder.email.text=list[position].email
    }

    override fun getItemCount(): Int {
        return list.size
    }
}