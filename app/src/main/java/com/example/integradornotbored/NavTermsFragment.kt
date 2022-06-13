package com.example.integradornotbored

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.integradornotbored.databinding.NavTermsBinding

class NavTermsFragment : Fragment() {

private lateinit var binding : NavTermsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = NavTermsBinding.inflate(inflater, container,false)

        binding.btTermsClose.setOnClickListener {
            findNavController().navigate(R.id.action_terms_to_start)
        }
        return binding.root
    }
}