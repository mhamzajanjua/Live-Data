package android.com.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModeWithArray : ViewModel() {

    var mutableLiveData : MutableLiveData<List<String>>? = null
    var listFruit : ArrayList<String>

    init {
        listFruit = ArrayList<String>()
    }

    fun getFruits() : MutableLiveData<List<String>> {
        if (mutableLiveData==null) {
            mutableLiveData = MutableLiveData<List<String>>()
            loadFruits()
        }
        return mutableLiveData!!
    }

    fun loadFruits() {
        listFruit.add("Mango")
        listFruit.add("Orange")
        listFruit.add("Apple")
        listFruit.add("Banana")
        mutableLiveData?.value = listFruit
    }
    fun addFruit() {
        listFruit.add("Grape")
        mutableLiveData?.value = listFruit
    }
}