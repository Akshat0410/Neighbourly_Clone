package com.example.neighbourly_clone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.neighbourly_clone.Model.RecyclerData
import com.example.neighbourly_clone.databinding.ActivityMainBinding.bind

class RecyclerAdapter(context: Context,data :ArrayList<RecyclerData>): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

      var data:ArrayList<RecyclerData> = data
      val maincontext:Context=context
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var recyclerimage: ImageView = itemView.findViewById(R.id.recyclerimage)
        var profileimage: ImageView = itemView.findViewById(R.id.recyclerprofile_image)
        var name: TextView  = itemView.findViewById(R.id.name)
        var timeago: TextView  = itemView.findViewById(R.id.timeago)
        var profilelocation: TextView = itemView.findViewById(R.id.location)
        var title: TextView  = itemView.findViewById(R.id.titleorquestion)
        var answerimage: ImageView = itemView.findViewById(R.id.recycleranswer_image)
        var answername: TextView = itemView.findViewById(R.id.answername)
        var answerdate:TextView= itemView.findViewById(R.id.answerdate)
        var answerlocation: TextView  = itemView.findViewById(R.id.answerlocation)
//        var firstanswer:= itemView.findViewById(R.id.firstanswer)
        var answercount:TextView   = itemView.findViewById(R.id.answercount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.recyclerdata,parent,false)
        return MyViewHolder(inflater)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

       holder.name.text=data[position].name
        holder.title.text=data[position].titleorquestion
//        Glide.with(holder.itemView).load(data[position].mainimage).into(holder.profileimage)

    }

    override fun getItemCount(): Int {
            return data.size
    }




}