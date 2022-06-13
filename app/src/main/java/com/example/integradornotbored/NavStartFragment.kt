package com.example.integradornotbored

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.integradornotbored.databinding.NavStartBinding

class NavStartFragment : Fragment() {


    private lateinit var binding: NavStartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = NavStartBinding.inflate(inflater, container,false)

        binding.btnStart.setOnClickListener {
            if (regexInt(binding.etParticipants.text.toString().toInt())) {
                val action = NavStartFragmentDirections.actionStartToActivities(
                    binding.etParticipants.text.toString().toInt()
                )
                findNavController().navigate(action)
                binding.btnStart.isEnabled = true

            } else {
                binding.btnStart.isEnabled = false
            }
        }

        binding.tvTerms.setOnClickListener {
            findNavController().navigate(R.id.action_start_to_terms)
        }

        return binding.root
        }
    private fun regexInt(input: Int): Boolean {
        val numRegex = "^[1-9][0-9]*\$".toRegex().matches(input.toString())
        return(numRegex)
    }
}

