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
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlue", "blue")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote2.setOnClickListener {
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionYellow", "yellow")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote4.setOnClickListener {
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionPurple", "purple")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote5.setOnClickListener {
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionGreen", "green")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote6.setOnClickListener {
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionOrange", "orange")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote7.setOnClickListener {
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlue", "blue")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
        fNote1.setOnClickListener {
            // bottom sheet -> fragment 로 broadcast 보내기
            val intent = Intent("bottom_sheet_action")
            intent.putExtra("actionBlack", "black")
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
            dismiss()
        }
    }
}