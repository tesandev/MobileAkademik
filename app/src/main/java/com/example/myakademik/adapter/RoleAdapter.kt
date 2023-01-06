package com.example.myakademik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myakademik.R
import com.example.myakademik.model.ResponseListRole
import com.example.myakademik.model.ResponsePhotos
import kotlinx.android.synthetic.main.item_role.view.*

class RoleAdapter(private val list:ArrayList<ResponsePhotos>):RecyclerView.Adapter<RoleAdapter.RoleViewHolder>() {
    inner class RoleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(role: ResponsePhotos){
            with(itemView){
                val textMerge = "${role.fullTitle}\n"+
                        "${role.year}\n"+
                        "${role.crew}\n"
                tvText.text = textMerge
                Glide.with(itemView)
                    .load(role.image)
                    .into(ivImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoleViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_role,parent,false)
        return RoleViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: RoleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}