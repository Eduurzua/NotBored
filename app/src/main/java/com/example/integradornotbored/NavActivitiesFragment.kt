package com.example.integradornotbored

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.integradornotbored.databinding.NavActivitiesBinding

class NavActivitiesFragment : Fragment() {

    private lateinit var binding: NavActivitiesBinding
    private val args : NavActivitiesFragmentArgs by navArgs()


    private val viewModel: ActivitiesViewModel by viewModels(
        factoryProducer = { ActivitiesViewModelFactory() }
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = NavActivitiesBinding.inflate(inflater, container, false)

        binding.rvActivities.layoutManager = LinearLayoutManager(context)
        setRepository()
        observerRepository()

        binding.btRandom.setOnClickListener {
              setListenerRandom()
        }
        return binding.root
    }

    private fun setRepository() {
        viewModel.loadRepository()
    }
    private fun observerRepository() {
        viewModel.activities.observe(viewLifecycleOwner) { value ->
            if (value != null) {
                val adapter = ActivitiesAdapter(object : ActivitiesAdapter.ActivitySelectionListener{
                    override fun select(activityName: String) {

                        viewModel.getPosts(activityName.toString().lowercase())

                        viewModel.post.observe(viewLifecycleOwner) { value ->
                            if (value != null) {
                                  val action = NavActivitiesFragmentDirections.actionActivitiesToSuggestion(value,activityName.toString())
                                findNavController().navigate(action)
                            }
                        }
                        viewModel.error.observe(viewLifecycleOwner) { value ->
                            if (value != null) {
                                Toast.makeText(context,value, Toast.LENGTH_LONG).show()
                            }
                        }

                    }
                })
                binding.rvActivities.adapter = adapter
                adapter.setActivities(value)
            }
        }
    }

    /*private fun setListenersActivities(name: String){

        println("Valor de actividades  :"+ name)
        //viewModel.getPosts(bindingItem.tvActivitiesItem.text.toString().lowercase())
        viewModel.getPosts(name)

        viewModel.post.observe(viewLifecycleOwner) { value ->
            if (value != null) {
              //  val action = NavActivitiesFragmentDirections.actionActivitiesToSuggestion(value,name.toString())
                //findNavController().navigate(action)
            }
        }
        viewModel.error.observe(viewLifecycleOwner) { value ->
            if (value != null) {
                Toast.makeText(context,value, Toast.LENGTH_LONG).show()
            }
        }
    }
    */

    private fun setListenerRandom()     {

        viewModel.getPost(args.key)

        viewModel.post.observe(viewLifecycleOwner) { value ->
            if (value?.activity != null) {
                val action = NavActivitiesFragmentDirections.actionActivitiesToSuggestion(
                    value, Companion.CT_RANDOM
                )
                findNavController().navigate(action)
            }
          //  Toast.makeText(context, CT_MESSAGE, Toast.LENGTH_SHORT).show()
        }
        viewModel.error.observe(viewLifecycleOwner) { value ->
            if (value != null) {
                Toast.makeText(context,value, Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        const val CT_RANDOM = "Random"
        const val CT_MESSAGE = "Number of participants not found, will be redirected to Start"

    }

}
