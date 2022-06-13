package com.example.integradornotbored
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.integradornotbored.databinding.NavActivitiesItemBinding


class ActivitiesAdapter(private val listener: ActivitySelectionListener): RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {

    private lateinit var activities: List<Activities>

    interface ActivitySelectionListener {
        fun select(activityName: String)
    }

    fun setActivities(newActivities : List<Activities>) {
        this.activities = newActivities
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NavActivitiesItemBinding.inflate(layoutInflater,parent,false)
        return ActivitiesViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        holder.bind(this.activities[position])
    }

    override fun getItemCount(): Int {
        return this.activities.size
    }

    class ActivitiesViewHolder( private val binding: NavActivitiesItemBinding, private val listener: ActivitySelectionListener
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(activities: Activities) {
            this.binding.tvActivitiesItem.text = activities.name
            this.binding.btNext.setOnClickListener{
           //     viewModel.getPosts(binding.tvActivitiesItem.text.toString().lowercase())
                listener.select(binding.tvActivitiesItem.text.toString().lowercase())
            }
        }
    }
}
