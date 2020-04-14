package com.kotlin.mvvmsampleapp.ui.auth

import com.kotlin.mvvmsampleapp.data.db.enteties.User

interface AuthListnerInterface {

    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message:String)
}