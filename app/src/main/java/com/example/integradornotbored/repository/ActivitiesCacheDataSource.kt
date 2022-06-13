package com.example.integradornotbored.repository

import com.example.integradornotbored.Activities

class ActivitiesCacheDataSource {

        private val activities: List<Activities> = listOf(
            Activities("Education"),
            Activities("Recreational"),
            Activities("Social"),
            Activities("Diy"),
            Activities("Charity"),
            Activities("Cooking"),
            Activities("Relaxation"),
            Activities( "Music"),
            Activities("Busywork")
        )

    fun getActivities(): List<Activities>? {
        return activities
    }
}