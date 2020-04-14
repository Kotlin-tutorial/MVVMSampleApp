package com.kotlin.mvvmsampleapp.data.network.responces

import com.kotlin.mvvmsampleapp.data.db.enteties.User

data class AuthResponce (
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)