package com.kotlin.mvvmsampleapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.kotlin.mvvmsampleapp.R
import com.kotlin.mvvmsampleapp.databinding.ActivityLoginBinding
import com.kotlin.mvvmsampleapp.util.toast

class LoginActivity : AppCompatActivity(), AuthListnerInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListnerInterface = this
    }

    override fun onStarted() {
            toast("Login Started")
        }

                override fun onSuccess() {
            toast("Login Success")
        }

                override fun onFailure(message: String) {
            toast(message)
    }


}
