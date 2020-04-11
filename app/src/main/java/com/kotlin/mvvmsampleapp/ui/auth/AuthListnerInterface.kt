package com.kotlin.mvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData

interface AuthListnerInterface {

    fun onStarted()
    fun onSuccess(loginResponce: LiveData<String>)
    fun onFailure(message:String)
}