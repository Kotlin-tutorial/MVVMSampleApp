package com.kotlin.mvvmsampleapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.mvvmsampleapp.data.db.enteties.CURRENT_USER_ID
import com.kotlin.mvvmsampleapp.data.db.enteties.User

interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User) : Long

    @Query("SELECT * From user WHERE uid = $CURRENT_USER_ID")
    fun getUser(): LiveData<User>
}