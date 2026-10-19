package com.example.naufallingzhi_tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.naufallingzhi_tia.DetailActivity
import com.example.naufallingzhi_tia.Home.pertemuan5.LimaActivity
import com.example.naufallingzhi_tia.Home.pertemuan6.EnamActivity
import com.example.naufallingzhi_tia.LoginActivity
import com.example.naufallingzhi_tia.R
import com.example.naufallingzhi_tia.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        // Mengambil data dari LoginActivity
        val user = requireActivity().intent.getStringExtra("username")
        val pass = requireActivity().intent.getStringExtra("password")
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        // Menampilkan username dan password
        binding.txtusername.text = user
        binding.txtpassword.text = pass


        // ==========================================
        // BUTTON ALERT
        // ==========================================

        binding.btnalert.setOnClickListener {

            MaterialAlertDialogBuilder(requireContext())
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
            val intent = Intent(requireContext(), DetailActivity::class.java)

            startActivity(intent)
        }


        // ==========================================
        // BUTTON LOGOUT
        // ==========================================

        binding.logout.setOnClickListener {

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin logout?")

                .setNegativeButton("Tidak") { dialog, _ ->

                    // Tetap berada di MainActivity
                    dialog.dismiss()
                }

                .setPositiveButton("Ya") { _, _ ->

                    // Pindah ke LoginActivity
                    val intent = Intent(requireContext(), LoginActivity::class.java)

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
            startActivity(Intent(requireContext(), LimaActivity::class.java))
        }

        binding.btnToEnam.setOnClickListener {
            startActivity(Intent(requireContext(), EnamActivity::class.java))
        }

        binding.btnlogout2.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
}
