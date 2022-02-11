package com.example.amazonui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonui.R
import com.example.amazonui.model.Essential

class EssentialAdapter( var context: Context , var items : ArrayList<Essential>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed,parent,false)
        return EssentialViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if(holder is EssentialViewHolder){
            var tv_title=holder.tv_title
            var iv_image= holder.iv_image

            tv_title.text=item.title
            iv_image.setImageResource(item.image)


        }
    }


    class EssentialViewHolder(view : View): RecyclerView.ViewHolder(view){
            val tv_title=view.findViewById<TextView>(R.id.tv_title)
        val  iv_image=view.findViewById<ImageView>(R.id.iv_iamge)
    }




}