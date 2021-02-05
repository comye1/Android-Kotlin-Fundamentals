package com.example.notesapp.util

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentNotesBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_notes_bottom_sheet.*

class NoteBottomSheetFragment : BottomSheetDialogFragment() {
    var selectedColor = "#121212"
    private var _binding:FragmentNotesBottomSheetBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): NoteBottomSheetFragment{
            val args = Bundle()
            val fragment = NoteBottomSheetFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_notes_bottom_sheet, null)
        dialog.setContentView(view)

        val param = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams

        val behavior = param.behavior

        if(behavior is BottomSheetBehavior<*>){
            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    var state = ""
                    when(newState){
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            state = "DRAGGING"
                        }
                        BottomSheetBehavior.STATE_SETTLING -> {
                            state = "SETTLING"
                        }
                        BottomSheetBehavior.STATE_EXPANDED -> {
                            state = "EXPANDED"
                        }
                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            state = "COLLAPSED"
                        }
                        BottomSheetBehavior.STATE_HIDDEN -> {
                            state = "HIDDEN"
                            dismiss()
                            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }
            })
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNotesBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_notes_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }
    private fun setListener(){
        binding.fNote1.setOnClickListener {

            binding.imgNote1.setImageResource(R.drawable.ic_tick)
            binding.imgNote2.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor = "#4e33ff"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlue", "Blue")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote2.setOnClickListener {

            binding.imgNote2.setImageResource(R.drawable.ic_tick)
            binding.imgNote1.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)

            selectedColor = "#ffd633"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionYellow", "Yellow")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote4.setOnClickListener {
            binding.imgNote4.setImageResource(R.drawable.ic_tick)
            binding.imgNote2.setImageResource(0)
            binding.imgNote1.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor = "#ae3b76"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionPurple", "Purple")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote5.setOnClickListener {
            binding.imgNote5.setImageResource(R.drawable.ic_tick)
            binding.imgNote2.setImageResource(0)
            binding.imgNote1.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor = "#0aebaf"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionGreen", "Green")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote6.setOnClickListener {
            binding.imgNote6.setImageResource(R.drawable.ic_tick)
            binding.imgNote2.setImageResource(0)
            binding.imgNote1.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            binding.imgNote7.setImageResource(0)
            selectedColor = "#ff7746"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionOrange", "Orange")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
        binding.fNote7.setOnClickListener {
            binding.imgNote7.setImageResource(R.drawable.ic_tick)
            binding.imgNote2.setImageResource(0)
            binding.imgNote1.setImageResource(0)
            binding.imgNote5.setImageResource(0)
            binding.imgNote6.setImageResource(0)
            binding.imgNote4.setImageResource(0)
            selectedColor = "#202734"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlack", "Black")
            intent.putExtra("selectedColor", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
        }
    }
}