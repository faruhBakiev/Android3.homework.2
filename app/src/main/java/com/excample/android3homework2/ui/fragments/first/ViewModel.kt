package com.excample.android3homework2.ui.fragments.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.excample.android3homework2.data.models.Model

class  ViewModel : ViewModel (){

    private val _liveData = MutableLiveData<List<Model>>()
    val liveData: LiveData<List<Model>> = _liveData

    private val addList = mutableListOf<Model>()

    fun addNote(number: String, title: String, description: String) {
        addList.add(Model(
            name = number,
            age = title,
            email = description
        ))
        _liveData.value = addList.toList()
    }
}
