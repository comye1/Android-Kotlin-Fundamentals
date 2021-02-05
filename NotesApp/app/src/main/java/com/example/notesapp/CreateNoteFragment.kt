package com.example.notesapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.notesapp.database.NotesDatabase
import com.example.notesapp.databinding.FragmentCreateNoteBinding
import com.example.notesapp.databinding.FragmentHomeBinding
import com.example.notesapp.entities.Notes
import com.example.notesapp.util.NoteBottomSheetFragment
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateNoteFragment : BaseFragment() {
    var selectedColor = "#222222" //기본 색 : lightBlack
    var currentDate:String? = null
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentCreateNoteBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
//        val view = binding.root
//        return view

        return binding.root
//        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
                BroadcastReceiver, IntentFilter("bottom_sheet_action")
        )

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        currentDate = sdf.format(Date())

        binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))/////////

        binding.tvDateTime.text = currentDate
        binding.imgDone.setOnClickListener {
            //save note
            saveNote()
        }

        binding.imgBack.setOnClickListener {
            replaceFragment(HomeFragment.newInstance(), false)
        }

        binding.imgMore.setOnClickListener {
            var noteBottomSheetFragment = NoteBottomSheetFragment.newInstance()
            noteBottomSheetFragment.show(requireActivity().supportFragmentManager, "Note Bottom Sheet Fragment")
        }
    }

    private fun saveNote(){

        if(binding.etNoteTitle.text.isNullOrEmpty()){
            Toast.makeText(context, "제목을 입력해주세요.", Toast.LENGTH_SHORT).show()
        }
        if(binding.etNoteSubTitle.text.isNullOrEmpty()){
            Toast.makeText(context, "소제목을 입력해주세요.", Toast.LENGTH_SHORT).show()
        }
        if(binding.etNoteDesc.text.isNullOrEmpty()) {
            Toast.makeText(context, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
        }

        launch {
            val notes = Notes()
            notes.title = binding.etNoteTitle.text.toString()
            notes.subTitle = binding.etNoteSubTitle.text.toString()
            notes.noteText = binding.etNoteDesc.text.toString()
            notes.dateTime = currentDate

            context?.let{
                NotesDatabase.getDatabase(it).noteDao().insertNotes(notes)
                binding.etNoteDesc.setText("")
                binding.etNoteTitle.setText("")
                binding.etNoteSubTitle.setText("")
            }
        }
    }

    private fun replaceFragment(fragment:Fragment, isTransition:Boolean){
        val fragmentTransition = activity!!.supportFragmentManager.beginTransaction()

        if (isTransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }

    private val BroadcastReceiver : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            var actionColor = intent!!.getStringExtra("actionColor")
            when(actionColor!!){
                "Blue" -> {
                    selectedColor = intent!!.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
                }

                "Yellow" -> {
                    selectedColor = intent!!.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                "Purple" -> {
                    selectedColor = intent!!.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
                }

                "Green" -> {
                    selectedColor = intent!!.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                "Orange" -> {
                    selectedColor = intent!!.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                "Black" -> {
                    selectedColor = intent!!.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))

                }

                else -> {
                    selectedColor = intent!!.getStringExtra("selectedColor")!!
                    binding.colorView.setBackgroundColor(Color.parseColor(selectedColor))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(BroadcastReceiver)
        super.onDestroy()
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                CreateNoteFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}