package com.example.integradornotbored.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Post(
    @SerializedName("activity")
    val activity: String,
    @SerializedName("accessibility")
    val accessibility : Double = 0.0,
    @SerializedName("type")
    val type: String,
    @SerializedName("participants")
    val participants: Int = 0,
    @SerializedName("price")
    val price: Double = 0.0,
    @SerializedName("key")
    val key: Int = 0,
) : Serializable