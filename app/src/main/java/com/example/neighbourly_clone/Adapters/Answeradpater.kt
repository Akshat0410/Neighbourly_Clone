package com.example.neighbourly_clone.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neighbourly_clone.Model.Answer
import com.example.neighbourly_clone.R

class Answeradpater(context: Context, data: ArrayList<Answer>) :
    RecyclerView.Adapter<Answeradpater.MyViewHolder>() {

    var answersdata: ArrayList<Answer> = data
    val maincontext: Context = context


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var profileimage: ImageView = itemView.findViewById(R.id.answerpersonimage)
        var name: TextView = itemView.findViewById(R.id.answername)
        var timeago: TextView = itemView.findViewById(R.id.answertime)
        var title: TextView = itemView.findViewById(R.id.answertitle)
        var thumbsup: ImageView = itemView.findViewById(R.id.thumbsup)
        var thumbdown: ImageView = itemView.findViewById(R.id.thumbsdown)
        var reply: ImageView = itemView.findViewById(R.id.reply)
        var menu: ImageView = itemView.findViewById(R.id.menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.answers, parent, false)
        return MyViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name.text = answersdata[position].answername
        holder.timeago.text = answersdata[position].answerdate
        holder.title.text = answersdata[position].answer
    }

    override fun getItemCount(): Int {
        return answersdata.size
    }


}