package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var firebaseAnalytics:FirebaseAnalytics
    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAnalytics= FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID,"some test")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT ,bundle)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.btnSignUp.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        auth= FirebaseAuth.getInstance()

        binding.btnSub.setOnClickListener {
          validateData()
        }

    }

    private fun validateData() {
      // val name=binding.etName.text.toString()
        val email=binding.etEmail.text.toString()
        val password=binding.etPassword.text.toString()

        if ( email.isNotEmpty() && password.isNotEmpty()){

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                val intent =Intent(this,SignInActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        }else{
            Toast.makeText(this,"Empty fields Are not Allowed !!",Toast.LENGTH_SHORT).show()
        }
    }

}