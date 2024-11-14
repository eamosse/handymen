package com.eamosse.android.data.repositories

import com.eamosse.android.data.api.NeighborService
import com.eamosse.android.data.di.DataModule
import com.eamosse.android.data.model.Neighbor

interface NeighborRepository {
    fun getNeighbors(): List<Neighbor>
}

internal class NeighborRepositoryImpl private constructor() : NeighborRepository {

    private val service: NeighborService = DataModule.provideNeighborService()

    override fun getNeighbors(): List<Neighbor> {
        return service.getNeighbors()
    }

    companion object {
        private var instance: NeighborRepository? = null

        fun instance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepositoryImpl()
            }
            return instance!!
        }
    }
}