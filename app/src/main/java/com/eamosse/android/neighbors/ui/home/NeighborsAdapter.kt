package com.eamosse.android.neighbors.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eamosse.android.neighbors.databinding.NeighborItemBinding
import com.eamosse.android.neighbors.model.NeighborModelView

class NeighborsAdapter : RecyclerView.Adapter<NeighborViewHolder>() {
    private val mDiffer: AsyncListDiffer<NeighborModelView> = AsyncListDiffer(this, DiffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NeighborViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: NeighborItemBinding = NeighborItemBinding.inflate(inflater, parent, false)
        return NeighborViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NeighborViewHolder, position: Int) {
        holder.bind(mDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    fun submitList(it: List<NeighborModelView>) {
        return mDiffer.submitList(it)
    }

    private object DiffCallback : DiffUtil.ItemCallback<NeighborModelView>() {
        override fun areItemsTheSame(
            oldItem: NeighborModelView,
            newItem: NeighborModelView
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NeighborModelView,
            newItem: NeighborModelView
        ): Boolean {
            return oldItem == newItem
        }

    }
}

class NeighborViewHolder(private val binding: NeighborItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(neighbor: NeighborModelView) {
        binding.neighborName.text = neighbor.name
    }
}