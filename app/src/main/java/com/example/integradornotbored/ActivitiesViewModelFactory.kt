package com.example.integradornotbored

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.integradornotbored.post.PostRemoteDataSource
import com.example.integradornotbored.post.PostRepository
import com.example.integradornotbored.repository.ActivitiesCacheDataSource
import com.example.integradornotbored.repository.ActivitiesRepository

class ActivitiesViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val cache = ActivitiesCacheDataSource()
        val remoteDataSource = PostRemoteDataSource()
        val repositoryPost = PostRepository(remoteDataSource)
        val repository = ActivitiesRepository(cache)

        return ActivitiesViewModel(repository,repositoryPost) as T
    }
}