package com.example.praktika16fgd

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


    }


    fun CALIK(view: View) {
        val url = "https://www.ects.ru"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    fun ALARM(view: View) {
        val intent = Intent(this, CreateAlarmActivity::class.java)
        startActivity(intent)
    }

    fun list(view: View) {
        val intent = Intent(this, EditTaskActivity::class.java)
        startActivity(intent)
    }


    fun nameandpass(view: View) {
      // val namedEditText = findViewById<EditText>(R.id.imya)
      //   val emailEditText = findViewById<EditText>(R.id.mail23)
      //   val name = namedEditText.text.toString().trim()
      //   val email = emailEditText.text.toString().trim()
     //   val message = "Имя: $name, Почта: $email"
     //    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }
    }
