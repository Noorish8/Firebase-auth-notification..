package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Getdata : AppCompatActivity() {
    lateinit var database: FirebaseDatabase
    lateinit var reference: DatabaseReference
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getdata)

        database=FirebaseDatabase.getInstance()
        reference =database.getReference("Users")

        getData()
    }
    private fun getData(){
        reference.addValueEventListener(object :ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.e("cancel", p0.toString())
            }
            override fun onDataChange(p0:DataSnapshot){
                var list=ArrayList<DatabaseModel>()
                for (data in p0.children)
                {
                    val model=data.getValue(DatabaseModel::class.java)
                    list.add(model as DatabaseModel )
                }
                if (list.size>0){
                    val adapter =DataAdapter(list)
                    recyclerView.adapter=adapter
                }
            }
        })

    }
}