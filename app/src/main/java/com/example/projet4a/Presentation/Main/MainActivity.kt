package com.example.projet4a.Presentation.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projet4a.Presentation.HomePage.HomePageActivity
import com.example.projet4a.Presentation.Registration.RegistrationActivity
import com.example.projet4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    val intent_to_home_page = Intent(this@MainActivity, HomePageActivity::class.java)
                    startActivity(intent_to_home_page)
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Problème de connexion")
                        .setMessage("Email ou mot de passe invalide")
                        .setPositiveButton("D'accord") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(email_edit.text.toString().trim(),password_edit.text.toString())
        }

        link_register_button.setOnClickListener {
            val intent_to_registration = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(intent_to_registration)
        }
    }
}