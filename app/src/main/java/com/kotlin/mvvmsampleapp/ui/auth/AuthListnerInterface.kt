package com.kotlin.mvvmsampleapp.ui.auth

interface AuthListnerInterface {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}