package com.example.naufallingzhi_tia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.naufallingzhi_tia.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Tombol Login
        binding.btnlogin.setOnClickListener {

            val user = binding.isiusername.text.toString()
            val pass = binding.isipassword.text.toString()

            // Intent LoginActivity -> MainActivity
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("username", user)
            intent.putExtra("password", pass)

            startActivity(intent)

            Log.d("Output", "Username: $user Password: $pass")

            Toast.makeText(
                this,
                "Username $user Password $pass",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}