package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.firebase.databinding.ActivitySignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        database=FirebaseDatabase.getInstance()
//        reference =database.getReference("Users")
//
//    }
//    private fun sendData(){
//        var name=binding.etName.text.toString()
//        var email=binding.etEmail.text.toString()
//        if (name.isNotEmpty() && email.isNotEmpty())
//        {
//            var model=DatabaseModel(name, email)
//            var id =reference.push().key
//
//            reference.child(id!!).setValue(model)
//            binding.etName.setText("")
//            binding.etEmail.setText("")
//
//
//        }else{
//            Toast.makeText(this,"All field is required",Toast.LENGTH_LONG).show()
//        }
   }
}