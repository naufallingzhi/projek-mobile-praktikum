package com.example.naufallingzhi_tia.Tutorial

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.naufallingzhi_tia.LoginActivity
import com.example.naufallingzhi_tia.databinding.FragmentTutorial3Binding

class FragmentTutorial3 : Fragment() {

    private var _binding: FragmentTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorial3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengarahkan tombol Login (btnLogin2) ke LoginActivity
        binding.btnLogin2.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)

            // Menutup TutorialScreenActivity agar saat tombol Back ditekan tidak kembali ke tutorial
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}