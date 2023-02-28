package com.alperyuceer.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alperyuceer.room.databinding.RecyclerviewRowBinding

class UserAdapter(val userList: List<User>):RecyclerView.Adapter<UserAdapter.UserHolder>() {
    class UserHolder(val binding: RecyclerviewRowBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.binding.rvTitle.text= userList.get(position).firstName
    }
}