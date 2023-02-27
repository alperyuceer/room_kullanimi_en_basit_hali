package com.alperyuceer.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @ColumnInfo("first_name") var firstName:String,
    @ColumnInfo("last_name") var lastName: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}