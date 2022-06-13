package com.example.integradornotbored.post

import com.example.integradornotbored.model.Post

class PostRepository(

    private val remoteDataSource: PostRemoteDataSource
) {

    fun getPost(id: Int, listener: ResponseListener<Post>) {
        this.remoteDataSource.getPost(id,listener)
    }

    fun getPosts(str: String, listener: ResponseListener<Post>) {
        this.remoteDataSource.getPosts(str,listener)
    }
}