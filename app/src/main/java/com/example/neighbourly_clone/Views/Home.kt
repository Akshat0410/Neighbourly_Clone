package com.example.neighbourly_clone.Views

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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

            val builder = AlertDialog.Builder(requireContext())
            val view = layoutInflater.inflate(R.layout.locationpopup, null)
            builder.setView(view)
            val dialog = builder.create()

            val window = dialog.window!!
            val wlp: WindowManager.LayoutParams = window.attributes
            wlp.gravity = Gravity.TOP
            wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
            window.attributes = wlp

            dialog.show()

        }

        binding.post.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_posting)
        }






        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}