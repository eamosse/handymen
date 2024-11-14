package com.eamosse.android.data.api

import com.eamosse.android.data.model.Neighbor
import com.eamosse.android.data.utils.DUMMY_NeighborS

interface NeighborService {
    fun getNeighbors(): List<Neighbor>
}

// We don't want this implementation to be visible by other modules
// Only the interface should be visible
internal class InMemoryNeighborService : NeighborService {
    private val _neighbors = DUMMY_NeighborS.toMutableList()
    override fun getNeighbors(): List<Neighbor> {
        // We return a copy of the list
        return _neighbors.toList()
    }

}

