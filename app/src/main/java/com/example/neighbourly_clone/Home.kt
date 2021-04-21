package com.example.neighbourly_clone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neighbourly_clone.Model.RecyclerData
import com.example.neighbourly_clone.Util.DataGenerator
import com.example.neighbourly_clone.databinding.FragmentHomeBinding


class Home : Fragment() {


    private  var _binding: FragmentHomeBinding?=null
    private val  binding get() = _binding!!
    private lateinit var mainrecycler: RecyclerView
    private lateinit var recycleradapter : RecyclerAdapter
    private lateinit var datainstance: DataGenerator
    private lateinit var data:ArrayList<RecyclerData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentHomeBinding.inflate(inflater, container, false)

          datainstance= DataGenerator()
           data=ArrayList()
          for(i in 0 until (20))
            data.add(datainstance.GenerateData())

        mainrecycler=binding.homerecycler
        mainrecycler.layoutManager = LinearLayoutManager(context)
        recycleradapter= RecyclerAdapter(requireContext(),data)
        mainrecycler.adapter=recycleradapter




        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}