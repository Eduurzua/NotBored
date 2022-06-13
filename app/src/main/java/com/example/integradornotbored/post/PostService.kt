package com.example.integradornotbored.post

import com.example.integradornotbored.model.Post
import retrofit2.Call
import retrofit2.http.*

interface PostService {


    @GET("/api/activity")//Endpoint
    fun getPost(@Query("participants") int : Int): Call<Post>

    @GET("/api/activity")//Endpoint
    fun getPosts(@Query("type") str : String): Call<Post>

    @POST("/posts")
    fun createPost(@Body post: Post): Call<Post>

    //@GET("/api/activity/")
    //fun getPosts(): Call<List<Post>>


}