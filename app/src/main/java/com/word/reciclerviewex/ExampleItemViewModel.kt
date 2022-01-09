package com.word.reciclerviewex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleItemViewModel : ViewModel() {
    private val mutableSelectedItem = MutableLiveData<List<ExampleItem>>()
    val itemList: LiveData<List<ExampleItem>> get() = mutableSelectedItem

    fun addItem(item: ExampleItem) {
        mutableSelectedItem.value = mutableSelectedItem.value?.toMutableList()?.apply {
            add(item)
            toList()
        }
    }

    fun deleteItem(item: ExampleItem) {
        mutableSelectedItem.value = mutableSelectedItem.value?.toMutableList()?.apply {
            remove(item)
            toList()
        }
    }

    fun initData(items: List<ExampleItem>) {
        mutableSelectedItem.value = items;
    }
}