package com.kotlin.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.kotlin.mvvmsampleapp.data.repositories.UserRepository

class AuthViewModel: ViewModel() {

    var email:String? = null
    var password:String? = null

    var authListnerInterface:AuthListnerInterface? = null

    fun onLoginButtonClick(view: View){

        authListnerInterface?.onStarted()

        if( email?.isEmpty() ?: true || password?.isEmpty() ?: true){
            authListnerInterface?.onFailure("Invalid email or pssword")
            return
        }

        //ToDo UserRepository use depandancy injection
        val loginResponceLiveData = UserRepository().userLogin(email.toString() , password.toString())
        authListnerInterface?.onSuccess(loginResponceLiveData)
    }
}