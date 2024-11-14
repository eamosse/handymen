package com.eamosse.android.neighbors.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eamosse.android.neighbors.databinding.AddNeighborFragmentBinding

class AddNeighborFragment : Fragment() {

    private lateinit var binding: AddNeighborFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addNeighborViewModel =
            ViewModelProvider(this).get(AddNeighborViewModel::class.java)

        binding = AddNeighborFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        addNeighborViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}