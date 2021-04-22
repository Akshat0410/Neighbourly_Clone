package com.example.neighbourly_clone.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.navigation.fragment.findNavController
import com.example.neighbourly_clone.R
import com.example.neighbourly_clone.databinding.FragmentPostingBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class Posting : Fragment() {
    private var _binding: FragmentPostingBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostingBinding.inflate(inflater, container, false)

        bottomSheetBehavior = BottomSheetBehavior.from(binding.postview)
        BottomSheetBehavior.from(binding.postview).apply {
            this.state = BottomSheetBehavior.STATE_COLLAPSED
            isDraggable = true
            peekHeight=200

        }

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                    findNavController().navigate(R.id.action_posting_to_home2)

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