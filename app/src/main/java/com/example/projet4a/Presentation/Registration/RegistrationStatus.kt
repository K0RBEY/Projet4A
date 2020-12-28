package com.example.projet4a.Presentation.Registration

sealed class RegistrationStatus

object RegistrationSuccess : RegistrationStatus()
object RegistrationNoInfoError : RegistrationStatus()
object RegistrationPasswordMatchingError : RegistrationStatus()
object RegistrationAlreadyExistError : RegistrationStatus()
object RegistrationError : RegistrationStatus()