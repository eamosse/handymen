package com.eamosse.android.data.di

import com.eamosse.android.data.api.InMemoryNeighborService
import com.eamosse.android.data.api.NeighborService
import com.eamosse.android.data.repositories.NeighborRepository
import com.eamosse.android.data.repositories.NeighborRepositoryImpl

object DataModule {
    fun provideNeighborRepository(): NeighborRepository {
        return NeighborRepositoryImpl.instance()
    }

    fun provideNeighborService(): NeighborService {
        return InMemoryNeighborService()
    }
}