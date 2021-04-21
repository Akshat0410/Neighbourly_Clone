@file:Suppress("DEPRECATION")

package com.example.neighbourly_clone

import android.os.Bundle
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.fragment.findNavController
import com.example.neighbourly_clone.databinding.FragmentHomeBinding
import com.example.neighbourly_clone.databinding.FragmentPostViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlin.concurrent.fixedRateTimer


class PostView : Fragment() {

    private var _binding: FragmentPostViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPostViewBinding.inflate(inflater, container, false)
        bottomSheetBehavior = BottomSheetBehavior.from(binding.mainview)
        BottomSheetBehavior.from(binding.mainview).apply {
            this.state = BottomSheetBehavior.STATE_EXPANDED
            isDraggable = true
//            peekHeight=300


        }
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback()
        {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if(newState<=BottomSheetBehavior.STATE_COLLAPSED)
                  findNavController().navigate(R.id.action_postView_to_home22)

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })






        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}