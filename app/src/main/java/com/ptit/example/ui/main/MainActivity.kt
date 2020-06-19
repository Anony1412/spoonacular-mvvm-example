package com.ptit.example.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ptit.example.R
import com.ptit.example.data.model.FoodDetail
import com.ptit.example.data.model.response.FoodRandomResponse
import com.ptit.example.data.repository.FoodRemoteRepository
import com.ptit.example.data.source.remote.FoodRemoteDataSource
import com.ptit.example.data.source.remote.api.ApiService
import com.ptit.example.data.source.remote.api.RetrofitInstance
import com.ptit.example.databinding.ActivityMainBinding
import com.ptit.example.ui.adapter.FoodAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)
    private val foodRemoteRepository by lazy {
        FoodRemoteRepository.getInstance(FoodRemoteDataSource(apiService))
    }
    private val mainViewModel = MainViewModel(foodRemoteRepository)
    private val disposable = CompositeDisposable()
    private var mainBinding: ActivityMainBinding? = null
    private val foodAdapter by lazy { FoodAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
        initViewModel()
    }

    private fun initView() {
        mainBinding?.recyclerViewFood?.adapter = foodAdapter
    }

    private fun initViewModel() {
        mainViewModel.getRandomFoods()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    initFoods(it)
                },
                {
                    notifyError(it.localizedMessage)
                }
            )
            .addTo(disposable)
    }

    private fun initFoods(randoms: FoodRandomResponse) {
        val foods = mutableListOf<FoodDetail>()
        randoms.recipes.forEach {
            foods.add(it)
        }
        foodAdapter.updateData(foods)
    }

    private fun notifyError(errorMessage: String) =
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}
