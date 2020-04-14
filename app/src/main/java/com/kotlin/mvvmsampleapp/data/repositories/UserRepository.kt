package com.kotlin.mvvmsampleapp.data.repositories

import androidx.lifecycle.MutableLiveData
import com.kotlin.mvvmsampleapp.data.db.AppDataBase
import com.kotlin.mvvmsampleapp.data.db.enteties.User
import com.kotlin.mvvmsampleapp.data.network.MyApi
import com.kotlin.mvvmsampleapp.data.network.responces.AuthResponce
import retrofit2.*




class UserRepository (
    private  val api:MyApi,
    private  val db:AppDataBase
){

    suspend fun userLogin(email:String, password:String) : Response<AuthResponce> {
        val loginResponce = MutableLiveData<String>()

        //ToDo Inject MyApi with dependancy injection (Remote data source)
        return  api.userLogin(email,password)

    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()


}