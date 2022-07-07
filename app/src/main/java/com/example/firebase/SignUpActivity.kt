package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    lateinit var database:FirebaseDatabase
    lateinit var reference: DatabaseReference
    lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSignUp.setOnClickListener { sendData() }

        binding.btnGetData.setOnClickListener { startActivity(Intent(applicationContext,Getdata::class.java)) }

//        binding.btnSignUp.setOnClickListener {
//            validateData()
//        }

        database= FirebaseDatabase.getInstance()
        reference =database.getReference("Users")

    }
    private fun sendData(){
        var name=binding.etName.text.toString()
        var email=binding.etEmail.text.toString()
        if (name.isNotEmpty() && email.isNotEmpty())
        {
            var model=DatabaseModel(name, email)
            var id =reference.push().key

            reference.child(id!!).setValue(model)
            binding.etName.setText("")
            binding.etEmail.setText("")


        }else{
            Toast.makeText(this,"All field is required",Toast.LENGTH_LONG).show()
        }
    }
    }

//        private fun validateData() {
//            // val name=binding.etName.text.toString()
//            val email=binding.etEmail.text.toString()
//            val password=binding.etPassword.text.toString()
//
//            if ( email.isNotEmpty() && password.isNotEmpty()){
//
//                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
//                    if (it.isSuccessful){
//                        val intent = Intent(this,SignInActivity::class.java)
//                        startActivity(intent)
//                    }else{
//                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }else{
//                Toast.makeText(this,"Empty fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
//            }
//        }

//}



