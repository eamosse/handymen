package com.eamosse.android.neighbors.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eamosse.android.neighbors.databinding.FavoriteNeighborsFragmentBinding

class FavoritesFragment : Fragment() {

    private lateinit var binding: FavoriteNeighborsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val favoritesViewModel =
            ViewModelProvider(this).get(FavoritesViewModel::class.java)

        binding = FavoriteNeighborsFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        favoritesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}