package com.example.praktika16fgd

import android.app.Notification
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.text.FieldPosition
import java.util.Random
import kotlin.random.Random as Random1


class CreateAlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.createalarmactivity)


        val checkboxes = arrayOf(
            findViewById<CheckBox>(R.id.check1),
            findViewById<CheckBox>(R.id.check2),
            findViewById<CheckBox>(R.id.check3),
            findViewById<CheckBox>(R.id.check4),
            findViewById<CheckBox>(R.id.check5),
            findViewById<CheckBox>(R.id.check6),
            findViewById<CheckBox>(R.id.check7)
        )
        val spinnerbox = arrayOf(
            findViewById<Spinner>(R.id.spinner),
            findViewById<Spinner>(R.id.spinner2)

        )

        val textboxews = arrayOf(
            findViewById<TextView>(R.id.text1),
            findViewById<TextView>(R.id.text2),
            findViewById<TextView>(R.id.text3),
            findViewById<TextView>(R.id.text4),
            findViewById<TextView>(R.id.text5),
            findViewById<TextView>(R.id.text6),
            findViewById<TextView>(R.id.text7)
        )
        for (i in checkboxes.indices) {
            checkboxes[i].setOnClickListener {
                val isChecked = checkboxes[i].isChecked
                val prevChecked = if (i > 0) checkboxes[i - 1].isChecked else false
                val nextChecked =
                    if (i < checkboxes.size - 1) checkboxes[i + 1].isChecked else false


                if (prevChecked || nextChecked) {

                    checkboxes[i].isChecked = false
                } else {
                    textboxews[i].visibility = if (isChecked) View.VISIBLE else View.GONE
                }
            }
        }

        val natik = arrayOf("Вы в этот день и время работате", "У вас в этот день и время выходной")
        for (i in spinnerbox.indices) {
            spinnerbox[i].onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    var count = 0
                    for (i2 in spinnerbox.indices) {
                        if (spinnerbox[i2].selectedItemPosition > 0) {
                            count++
                        }
                        if (count == 2) {
                            val randomNotf = natik[Random().nextInt(natik.size)]
                            Toast.makeText(applicationContext, randomNotf, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}


            }


            val countries = arrayOf(
                "12:30",
                "13:00",
                "13:30",
                "14:00",
                "14:30",
                "15:00",
                "15:30",
                "16:00",
                "16:30"
            )
            val Spinner: Spinner = findViewById(R.id.spinner)
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

            Spinner.adapter = adapter


            val countries2 = arrayOf(
                "14.01.2021",
                "15.01.2021",
                "16.01.2021",
                "17.01.2021",
                "18.01.2021",
                "19.01.2021",
                "20.01.2021",
                "21.01.2021",
                "22.01.2021"
            )
            val spinner2: Spinner = findViewById(R.id.spinner2)
            val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries2)
            adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            spinner2.adapter = adapter2

        }


    }

    fun navigator(view: View) {
        val intent = Intent(this, EditTaskActivity::class.java)
        startActivity(intent)
        val message = "Вы успешно добавили будильник"

        startActivity(intent)
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }

    fun back2(view: View) { val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)}


}

