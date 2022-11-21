package com.example.assignment_1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("posts")
    fun getPosts(): Call<PostModel>
}