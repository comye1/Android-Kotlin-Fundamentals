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
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_notes_bottom_sheet.*

class NoteBottomSheetFragment : BottomSheetDialogFragment() {
    var selectedColor = "#121212"
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
        return inflater.inflate(R.layout.fragment_notes_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }
    private fun setListener(){
        fNote1.setOnClickListener {

            imgNote1.setImageResource(R.drawable.ic_tick)
            imgNote2.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            selectedColor = "#4e33ff"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlue", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote2.setOnClickListener {

            imgNote2.setImageResource(R.drawable.ic_tick)
            imgNote1.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)

            selectedColor = "#ffd633"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionYellow", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote4.setOnClickListener {
            imgNote4.setImageResource(R.drawable.ic_tick)
            imgNote2.setImageResource(0)
            imgNote1.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            selectedColor = "#ae3b76"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionPurple", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote5.setOnClickListener {
            imgNote5.setImageResource(R.drawable.ic_tick)
            imgNote2.setImageResource(0)
            imgNote1.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote7.setImageResource(0)
            selectedColor = "#0aebaf"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionGreen", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote6.setOnClickListener {
            imgNote6.setImageResource(R.drawable.ic_tick)
            imgNote2.setImageResource(0)
            imgNote1.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote4.setImageResource(0)
            imgNote7.setImageResource(0)
            selectedColor = "#ff7746"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionOrange", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote7.setOnClickListener {
            imgNote7.setImageResource(R.drawable.ic_tick)
            imgNote2.setImageResource(0)
            imgNote1.setImageResource(0)
            imgNote5.setImageResource(0)
            imgNote6.setImageResource(0)
            imgNote4.setImageResource(0)
            selectedColor = "#202734"
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlack", selectedColor)
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
    }
}