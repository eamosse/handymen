package com.eamosse.android.neighbors.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eamosse.android.data.di.DataModule
import com.eamosse.android.data.model.Neighbor
import com.eamosse.android.neighbors.model.NeighborModelView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NeighborsUseCase {
    private val repository = DataModule.provideNeighborRepository()
    suspend operator fun invoke(): LiveData<List<NeighborModelView>> {
        val liveData = MutableLiveData<List<NeighborModelView>>()
        doInBackGround(liveData)
        return liveData
    }

    private suspend fun doInBackGround(liveData: MutableLiveData<List<NeighborModelView>>) =
        withContext(Dispatchers.IO) {
            val neighbors = repository.getNeighbors()
            neighbors.map { it.toNeighborModelView() }.also {
                // be careful to use postValue instead of setValue in a background thread
                liveData.postValue(it)
            }
        }
}

private fun Neighbor.toNeighborModelView() = NeighborModelView(
    id = id,
    name = name
)