package com.example.naufallingzhi_tia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.naufallingzhi_tia.databinding.ActivityMainBinding
import com.example.naufallingzhi_tia.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
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

        // Mengambil data dari LoginActivity
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")

        // Menampilkan username dan password
        binding.txtusername.text = user
        binding.txtpassword.text = pass


        // ==========================================
        // BUTTON ALERT
        // ==========================================

        binding.btnalert.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")

                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }

                .setPositiveButton("Hapus") { dialog, _ ->

                    // Menghapus username dan password
                    binding.txtusername.text = ""
                    binding.txtpassword.text = ""

                    dialog.dismiss()
                }

                .setCancelable(false)
                .show()
        }


        // ==========================================
        // BUTTON JUDUL PROJEK
        // btnsnackbar = Judul Projek
        // ==========================================

        binding.btnsnackbar.setOnClickListener {

                // Intent MainActivity -> DetailActivity
                val intent = Intent(this, DetailActivity::class.java)

                startActivity(intent)
        }


        // ==========================================
        // BUTTON LOGOUT
        // ==========================================

        binding.logout.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin logout?")

                .setNegativeButton("Tidak") { dialog, _ ->

                    // Tetap berada di MainActivity
                    dialog.dismiss()
                }

                .setPositiveButton("Ya") { _, _ ->

                    // Pindah ke LoginActivity
                    val intent = Intent(this, LoginActivity::class.java)

                    // Menghapus MainActivity dari back stack
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                }

                .setCancelable(false)
                .show()
        }

        binding.btnToLima.setOnClickListener {
            startActivity(Intent(this, LimaActivity::class.java))
        }
    }
}