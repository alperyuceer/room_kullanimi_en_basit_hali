package com.alperyuceer.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.alperyuceer.room.databinding.ActivityListBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(applicationContext,UserDataBase::class.java,"Users").build()
        val userDao = db.userDao()

        compositeDisposable.add(
            userDao.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )



    }
    private fun handleResponse(userList: List<User>){
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = UserAdapter(userList)
        binding.recyclerView.adapter = adapter
    }
}