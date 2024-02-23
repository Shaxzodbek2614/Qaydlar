package com.example.qayta.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qayta.Models.User
import com.example.qayta.databinding.ItemRvBinding

private const val TAG = "UserAdapter"
class UserAdapter(var rvAction: RvAction , var list:ArrayList<User>): RecyclerView.Adapter<UserAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(user: User, position: Int) {

            itemRvBinding.title.text = user.title
            itemRvBinding.time.text = user.time
            itemRvBinding.menu.setOnClickListener {
                rvAction.clicMenu(itemRvBinding.menu,position)
            }
            itemRvBinding.root.setOnClickListener {
                rvAction.itemClic(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    interface RvAction{
        fun itemClic(user: User)
        fun clicMenu(view: View, position: Int)
    }
}