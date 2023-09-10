package com.example.praktika16fgd

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.praktika16fgd.R.id.*

import com.google.android.material.snackbar.Snackbar



class UserLogin : AppCompatActivity() {
    private lateinit var passwordEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var namedEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val savedName = prefs.getString("name", "")
        val savedEmail = prefs.getString("email", "")
        val savedPassword = prefs.getString("password", "")
        setContentView(R.layout.activity_user_login)
        passwordEditText = findViewById(pass)
        emailEditText = findViewById(mail23)
        namedEditText = findViewById(imya)
        if (savedName?.isNotEmpty() == true && savedEmail?.isNotEmpty() == true && savedPassword?.isNotEmpty() == true) {
            showConfirmationDialog()
        }

        namedEditText.setText(savedName)
        emailEditText.setText(savedEmail)
        passwordEditText.setText(savedPassword)
    }

    override fun onStop() {
        super.onStop()

        val prefs = getSharedPreferences("UserData", Context.MODE_PRIVATE).edit()
        prefs.putString("name", namedEditText.text.toString())
        prefs.putString("email", emailEditText.text.toString())
        prefs.putString("password", passwordEditText.text.toString())
        prefs.apply()
    }
    fun showConfirmationDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage("Хотите использовать сохраненные данные пользователя?")
            setPositiveButton("Да") { dialog, id ->

            }
            setNegativeButton("Нет") { dialog, id ->
                namedEditText.setText("")
                emailEditText.setText("")
                passwordEditText.setText("")
            }
        }
        builder.create().show()
    }
    fun navigtosett(view: View) {
        passwordEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val password = passwordEditText.text.toString().trim()
                if (password.isEmpty()) {
                    passwordEditText.setError("Введите пароль")
                }
            }
        }
        namedEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val name = namedEditText.text.toString().trim()
                if (name.isEmpty()) {
                    namedEditText.setError("Введите имя пользователя")
                }
            }
        }
        emailEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val email = emailEditText.text.toString().trim()
                if (email.isEmpty()) {
                    emailEditText.setError("Введите почту")
                }
            }
        }
        val password = passwordEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val name = namedEditText.text.toString().trim()

        if (password.isEmpty()) {
            passwordEditText.setError("Введите пароль")
        } else if (email.isEmpty()) {
            emailEditText.setError("Введите почту")
        } else if (name.isEmpty()) {
            namedEditText.setError("Введите имя пользователя")
        } else {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            Snackbar.make(view, "Вы успешно зарегистрировались", Snackbar.LENGTH_SHORT).show()
        }
    }


    fun backing(view: View)
    {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}