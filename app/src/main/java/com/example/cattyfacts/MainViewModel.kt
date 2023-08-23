package com.example.cattyfacts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cattyfacts.api.ApiFactory
import com.example.cattyfacts.pojo.Data
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {

   private val fact = MutableLiveData<String>()

    private val compositeDisposable = CompositeDisposable()



    fun getCatFact(): LiveData<String>{
        return fact
    }

     fun loadData(){
        val disposable = ApiFactory.apiService.getFact()
            .map { it.data?.joinToString("") { it } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                fact.postValue(it)
            }, {
                Log.d("MainViewModel", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}