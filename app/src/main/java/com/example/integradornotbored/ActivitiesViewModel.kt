package com.example.integradornotbored

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.integradornotbored.model.Post
import com.example.integradornotbored.post.PostRepository
import com.example.integradornotbored.post.RepositoryError
import com.example.integradornotbored.post.RepositoryResponse
import com.example.integradornotbored.post.ResponseListener
import com.example.integradornotbored.repository.ActivitiesRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ActivitiesViewModel(
    private val repository: ActivitiesRepository,
    private val repositoryPost: PostRepository
) : ViewModel() {

    val activities = MutableLiveData<List<Activities>?>(null)
    val post = MutableLiveData<Post?>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getPost(id: Int) {

        error.value = null
        post.value = null
        loading.value = true

        repositoryPost.getPost(id, object : ResponseListener<Post> {

            override fun onResponse(response: RepositoryResponse<Post>) {
                val postResponse = response.data
                loading.value = false
                error.value = null
                post.value = postResponse

            }



            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                post.value = null



            }

        })
    }

    fun getPosts(str: String) {

        error.value = null
        post.value = null
        loading.value = true

        repositoryPost.getPosts(str, object : ResponseListener<Post> {

            override fun onResponse(response: RepositoryResponse<Post>) {
                val postResponse = response.data

                loading.value = false
                error.value = null
                post.value = postResponse
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                post.value = null
            }

        })
    }

    fun loadRepository() {
        val repoActivities = repository.getActivities()
        activities.value = repoActivities
    }

    fun loadDelay() {
        viewModelScope.launch {
            delay(10000)
        }

    }

}