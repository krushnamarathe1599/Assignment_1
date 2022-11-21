package com.example.assignment_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var postsList: ArrayList<Posts>
    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        postsList = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        postAdapter = PostAdapter(this@MainActivity, postsList)
        recyclerView.adapter = postAdapter




        ApiUtilities.getApiInterface()?.getPosts()?.enqueue(object : Callback<PostModel>{
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                postsList.clear()
                if (response.isSuccessful){
                    postsList.addAll(response.body()!!.posts)
                    postAdapter.notifyDataSetChanged()
                }
                else{
                    Toast.makeText(this@MainActivity, "Not able to get", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Try Again", Toast.LENGTH_SHORT).show()
            }


        })


    }
}