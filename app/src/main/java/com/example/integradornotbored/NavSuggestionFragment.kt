package com.example.integradornotbored

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.rangeTo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.integradornotbored.databinding.NavSuggestionBinding



class NavSuggestionFragment : Fragment(){

    private lateinit var binding : NavSuggestionBinding
    private val args : NavSuggestionFragmentArgs by navArgs()

            private val viewModel: ActivitiesViewModel by viewModels(
        factoryProducer = { ActivitiesViewModelFactory() }
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = NavSuggestionBinding.inflate(inflater, container,false)

        binding.tvActivitiesTitle.text = args.title.substring(0,1).uppercase() + args.title.substring(1).lowercase()
        binding.tvTypeApi.text = args.post.type.substring(0,1).uppercase() + args.post.type.substring(1).lowercase()
        binding.tvActivitiesApi.text = args.post.activity
        binding.tvParticipantsApi.text = args.post.participants.toString()


        when(args.post.price) {
            0.0 -> binding.tvPriceApi.text = Companion.CT_FREE
            in 0.1..0.3 -> binding.tvPriceApi.text = Companion.CT_LOW
            in 0.4..0.6 -> binding.tvPriceApi.text = Companion.CT_MEDIUM
            in 0.7..100.00 -> binding.tvPriceApi.text = Companion.CT_HIGH
            else -> binding.tvPriceApi.text = Companion.CT_FREE
        }

        val action = NavSuggestionFragmentDirections.actionSuggestionToActivities(args.post.participants)
        binding.btBackList.setOnClickListener {

            findNavController().navigate(action)
        }


        binding.btnTryAnother.setOnClickListener {
            findNavController().navigate(action)
            }

        return binding.root
    }

    companion object {
        const val CT_LOW = "Low"
        const val CT_FREE = "Free"
        const val CT_MEDIUM = "Medium"
        const val CT_HIGH = "High"
    }
}