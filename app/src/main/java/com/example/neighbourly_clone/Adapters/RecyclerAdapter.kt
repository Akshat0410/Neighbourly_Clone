package com.example.neighbourly_clone.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.neighbourly_clone.Model.RecyclerData
import com.example.neighbourly_clone.R

class RecyclerAdapter(context: Context, data: ArrayList<RecyclerData>, navigation: NavController) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private val navController: NavController = navigation
    var data: ArrayList<RecyclerData> = data
    val maincontext: Context = context

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var recyclerimage: ImageView = itemView.findViewById(R.id.recyclerimage)
        var profileimage: ImageView = itemView.findViewById(R.id.recyclerprofile_image)
        var name: TextView = itemView.findViewById(R.id.name)
        var timeago: TextView = itemView.findViewById(R.id.timeago)
        var profilelocation: TextView = itemView.findViewById(R.id.location)
        var title: TextView = itemView.findViewById(R.id.titleorquestion)
        var answerimage: ImageView = itemView.findViewById(R.id.recycleranswer_image)
        var answername: TextView = itemView.findViewById(R.id.answername)
        var answerdate: TextView = itemView.findViewById(R.id.answerdate)
        var answerlocation: TextView = itemView.findViewById(R.id.answerlocation)
        var answercount: TextView = itemView.findViewById(R.id.answercount)
        var questionanswer: TextView=itemView.findViewById(R.id.questionanswer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerdata, parent, false)
        return MyViewHolder(inflater)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         var index=position%3

        if (index==0)
            holder.recyclerimage.visibility=View.GONE

        holder.name.text = data[position].name
        holder.title.text = data[position].titleorquestion
        holder.answercount.text=data[position].answercount
        holder.timeago.text=data[position].timeago
        holder.profilelocation.text=data[position].location
        holder.questionanswer.text=data[position].answer

        holder.itemView.setOnClickListener {
            navController.navigate(R.id.action_home2_to_postView)
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }


}