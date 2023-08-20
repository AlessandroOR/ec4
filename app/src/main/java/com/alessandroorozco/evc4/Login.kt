package com.alessandroorozco.evc4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class Login : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        emailEditText.addTextChangedListener { validateFields() }
        passwordEditText.addTextChangedListener { validateFields() }
    }

    fun onLoginButtonClick(view: View) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (isValidEmail(email) && password.length >= 6) {
            if (email == "ejemplo@idat.edu.pe" && password == "123456") {

                Toast.makeText(this, "Inicio de sesión exitoso.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {

                Toast.makeText(this, "Credenciales incorrectas. Inténtalo nuevamente.", Toast.LENGTH_SHORT).show()
            }
        } else {

            Toast.makeText(this, "Ingresa un correo y contraseña válidos.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validateFields() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        loginButton.isEnabled = isValidEmail(email) && password.length >= 6
    }
}