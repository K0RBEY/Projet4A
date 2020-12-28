package com.example.projet4a.Presentation.Main

sealed class LoginStatus

object LoginSuccess : LoginStatus()
object LoginError : LoginStatus()
