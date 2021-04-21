package com.example.neighbourly_clone.Views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neighbourly_clone.Adapters.RecyclerAdapter
import com.example.neighbourly_clone.Model.RecyclerData
import com.example.neighbourly_clone.R
import com.example.neighbourly_clone.Util.DataGenerator
import com.example.neighbourly_clone.databinding.FragmentHomeBinding


class Home : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainrecycler: RecyclerView
    private lateinit var recycleradapter: RecyclerAdapter
    private lateinit var datainstance: DataGenerator
    private lateinit var data: ArrayList<RecyclerData>
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        datainstance = DataGenerator()
        data = ArrayList()
        for (i in 0 until (20))
            data.add(datainstance.GenerateData())
        navController = findNavController()
        mainrecycler = binding.homerecycler
        mainrecycler.layoutManager = LinearLayoutManager(context)
        recycleradapter = RecyclerAdapter(requireContext(), data, navController)
        mainrecycler.adapter = recycleradapter

        binding.mapButton.setOnClickListener {

            val window=PopupWindow(requireContext())
            val view=layoutInflater.inflate(R.layout.locationpopup,null)
            window.contentView=view

            window.showAsDropDown(binding.mapButton)
          
        }
//        binding.root.setOnClickListener {
//            window.dismiss()
//        }



        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}