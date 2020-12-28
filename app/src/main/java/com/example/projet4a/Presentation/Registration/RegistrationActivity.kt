package com.example.projet4a.Presentation.Registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projet4a.Presentation.HomePage.HomePageActivity
import com.example.projet4a.Presentation.Main.*
import com.example.projet4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_registration.*
import org.koin.android.ext.android.inject

class RegistrationActivity : AppCompatActivity() {

    val registrationViewModel : RegistrationViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        register_button.setOnClickListener{
            registrationViewModel.onClickedVerifyRegistration(
                    email_registration.text.toString().trim(),
                    password_registration.text.toString(),
                    password_registration_validation.text.toString()
            )
        }

        registrationViewModel.registrationLiveData.observe(this, Observer {
            when (it) {
                is RegistrationSuccess -> {
                    registrationViewModel.register(email_registration.text.toString().trim(), password_registration.text.toString())
                    val intent_to_home_page = Intent(this@RegistrationActivity, HomePageActivity::class.java)
                    startActivity(intent_to_home_page)
                }
                RegistrationNoInfoError -> {
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Erreur de formulaire")
                            .setMessage("Vérifiez d'avoir bien rempli le formulaire en entier")
                            .setPositiveButton("D'accord") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                }
                RegistrationAlreadyExistError -> {
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Utilisateur déjà existant")
                            .setMessage("L'adresse email est déjà associée à un utilisateur")
                            .setPositiveButton("D'accord") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                }
                RegistrationPasswordMatchingError -> {
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Erreur de mot de passe")
                            .setMessage("Les mots de passe renseignés ne sont pas les mêmes")
                            .setPositiveButton("D'accord") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                }
                RegistrationError -> {
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Erreur d'inscription")
                            .setMessage("Veuillez réessayer de vous inscrire")
                            .setPositiveButton("D'accord") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                }
            }
        })
    }
}