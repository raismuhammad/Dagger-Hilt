package com.raisproject.localdatacrud.ui.listdata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raisproject.localdatacrud.data.model.Data
import com.raisproject.localdatacrud.repository.DummyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val dummyRepository: DummyRepository
) : ViewModel() {

    private val dataEventChannel = Channel<DataEvent>()
    val dataEvent = dataEventChannel.receiveAsFlow()

    fun getListData() {
        viewModelScope.launch(Dispatchers.IO) {
            dummyRepository.getDataDummy().body()
        }
    }

    fun saveData(data: Data) {
        viewModelScope.launch {
            dummyRepository.insertData(data)
            dataEventChannel.send(DataEvent.ShowDataSavedMessage("Data Saved."))
        }
    }

    sealed class DataEvent {
        data class ShowDataSavedMessage(val message: String): DataEvent()

    }
}