package com.alperyuceer.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable


@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): Flowable<List<User>>

     @Insert
     fun insert(user: User): Completable

     @Delete
     fun delete(user: User):Completable
}