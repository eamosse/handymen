package com.eamosse.android.neighbors.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eamosse.android.neighbors.domain.NeighborsUseCase
import com.eamosse.android.neighbors.model.NeighborModelView
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val neighborsUseCase = NeighborsUseCase()

    // A mediator live data to store the list of neighbors, we keep it private to avoid external modification
    private val _neighbors = MediatorLiveData<List<NeighborModelView>>()

    // A read-only data to expose the list of neighbors, this is made public to be observed by the view
    val neighbors: LiveData<List<NeighborModelView>> = _neighbors

    init {
        // Since the neighborsUseCase is a suspend function, we need to call it inside a coroutine
        viewModelScope.launch {
            // A mediator live data can observe multiple live data sources, and update its value when any of them changes
            _neighbors.addSource(neighborsUseCase()) {
                _neighbors.value = it
            }
        }
    }
}