package com.kotlin.mvvmsampleapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.mvvmsampleapp.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.*




class UserRepository {

    fun userLogin(email:String, password:String) : LiveData<String> {
        val loginResponce = MutableLiveData<String>()

        //ToDo Inject MyApi with dependancy injection (Remote data source)
        MyApi().userLogin(email,password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponce.value = t.message
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if(response.isSuccessful)
                         loginResponce.value = response.body()?.string()
                    else
                        loginResponce.value = response.errorBody()?.string()
                }

            })
        return loginResponce
    }
}