@file:Suppress("DEPRECATION")

package com.example.neighbourly_clone.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neighbourly_clone.Adapters.Answeradpater
import com.example.neighbourly_clone.Model.Answer
import com.example.neighbourly_clone.R
import com.example.neighbourly_clone.Util.AnswerGenerator
import com.example.neighbourly_clone.databinding.FragmentPostViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class PostView : Fragment() {

    private var _binding: FragmentPostViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>
    private lateinit var answerrecycler: RecyclerView
    private lateinit var recycleradapter: Answeradpater
    private lateinit var datainstance: AnswerGenerator
    private lateinit var answerdata: ArrayList<Answer>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPostViewBinding.inflate(inflater, container, false)
        datainstance = AnswerGenerator()
        answerdata = ArrayList()
        for (i in 0 until (20))
            answerdata.add(datainstance.GenerateAnswer())

        bottomSheetBehavior = BottomSheetBehavior.from(binding.mainview)
        BottomSheetBehavior.from(binding.mainview).apply {
            this.state = BottomSheetBehavior.STATE_EXPANDED
            isDraggable = true
            peekHeight = 300
        }
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                    findNavController().navigate(R.id.action_postView_to_home22)

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })

        answerrecycler = binding.answerrecycler
        answerrecycler.layoutManager = LinearLayoutManager(context)
        recycleradapter = Answeradpater(requireContext(), answerdata)
        answerrecycler.adapter = recycleradapter





        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}