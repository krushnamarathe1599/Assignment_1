package com.example.assignment_1

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PostAdapter(private val context:Context,private val posts:ArrayList<Posts>): RecyclerView.Adapter<PostAdapter.viewHolder>() {



    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val userIdTv: TextView? = itemView.findViewById(R.id.userId_tv)
        val idTv: TextView? = itemView.findViewById(R.id.id_tv)
        val titleTv: TextView? = itemView.findViewById(R.id.title_tv)
        val bodyTv: TextView? = itemView.findViewById(R.id.body_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,null,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val post:Posts = posts[position]
        holder.userIdTv?.text = post.userId
        holder.idTv?.text = post.id
        holder.titleTv?.text = post.title
        holder.bodyTv?.text = post.body


    }

    override fun getItemCount(): Int {
        return posts.size
    }


}