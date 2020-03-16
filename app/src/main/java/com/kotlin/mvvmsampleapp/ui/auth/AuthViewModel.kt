package com.kotlin.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {

    var email:String? = null
    var password:String? = null

    var authListnerInterface:AuthListnerInterface? = null

    fun onLoginButtonClick(view: View){

        if( email?.isNotEmpty() ?: true || password?.isNotEmpty() ?: true){
            authListnerInterface?.onFailure("Invalid email or pssword")
            return
        }
        authListnerInterface?.onSuccess()
    }
}