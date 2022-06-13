package com.example.integradornotbored.repository

import com.example.integradornotbored.Activities

class ActivitiesRepository (
    private val cache: ActivitiesCacheDataSource
) {
    fun getActivities(): List<Activities>? {
        return cache.getActivities()
    }

}
