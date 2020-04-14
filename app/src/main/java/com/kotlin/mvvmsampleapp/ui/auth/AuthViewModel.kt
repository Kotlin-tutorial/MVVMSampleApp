package com.kotlin.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.kotlin.mvvmsampleapp.data.repositories.UserRepository
import com.kotlin.mvvmsampleapp.util.Coroutines

class AuthViewModel (
    private val repository: UserRepository
): ViewModel() {

    var email:String? = null
    var password:String? = null

    var authListnerInterface:AuthListnerInterface? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClick(view: View){

        authListnerInterface?.onStarted()

        if( email?.isEmpty() ?: true || password?.isEmpty() ?: true){
            authListnerInterface?.onFailure("Invalid email or pssword")
            return
        }

        Coroutines.main {
            //ToDo UserRepository use depandancy injection
            val responce = repository.userLogin(email.toString(),password.toString())
            if(responce.isSuccessful){
                authListnerInterface?.onSuccess(responce.body()?.user!!)
                repository.saveUser(responce.body()?.user!!)
            }else{
                authListnerInterface?.onFailure("Error Code: ${responce.code()}")
            }
        }

    }
}