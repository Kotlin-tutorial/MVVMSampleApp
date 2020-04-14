package com.kotlin.mvvmsampleapp

import android.app.Application
import com.kotlin.mvvmsampleapp.data.db.AppDataBase
import com.kotlin.mvvmsampleapp.data.network.MyApi
import com.kotlin.mvvmsampleapp.data.repositories.UserRepository
import com.kotlin.mvvmsampleapp.ui.auth.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class MVVMAplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@MVVMAplication))

        //Kodein depandancy injection
        //Order of the items is important, for example User repository needs MyApi() + AppDataBase() therfore those need to be bind first
        bind() from singleton { MyApi() }
        bind() from singleton { AppDataBase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }

    }


}