package com.kotlin.mvvmsampleapp.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kotlin.mvvmsampleapp.R
import com.kotlin.mvvmsampleapp.data.db.enteties.User
import com.kotlin.mvvmsampleapp.databinding.ActivityLoginBinding
import com.kotlin.mvvmsampleapp.util.hide
import com.kotlin.mvvmsampleapp.util.show
import com.kotlin.mvvmsampleapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListnerInterface, KodeinAware {

    //Dependancy injection
    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListnerInterface = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null){
                //Do somrthing
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user:User) {
        progress_bar.hide()
        toast("${user.name} is Logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }


}
