package com.example.praktika16fgd



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter

import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*


class EditTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)
        val countries =
            arrayOf("12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30")
        val Spinner: Spinner = findViewById(R.id.simple_spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Spinner.adapter = adapter

        val spinnerbox = arrayOf(
            findViewById<Spinner>(R.id.simple_spinner),
            findViewById<Spinner>(R.id.simple_spinner2)
        )
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
            val Spinner2: Spinner = findViewById(R.id.simple_spinner2)
            val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries2)
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            Spinner2.adapter = adapter2
        }


    }
    data class Task(
        val title: String,
        val category: String,
        val date: String,
        val description: String
    )

    class TaskViewModel : ViewModel() {
        private val taskList = MutableLiveData<List<Task>>()

        fun getTaskList(): LiveData<List<Task>> {
            return taskList
        }

        fun addTask(task: Task) {
            val list = taskList.value?.toMutableList() ?: mutableListOf()
            list.add(task)
            taskList.value = list
        }

        fun editTask(position: Int, task: Task) {
            val list = taskList.value?.toMutableList() ?: mutableListOf()
            list[position] = task
            taskList.value = list
        }

        fun deleteTask(position: Int) {
            val list = taskList.value?.toMutableList() ?: mutableListOf()
            list.removeAt(position)
            taskList.value = list
        }
    }

    fun edit_zad(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
    fun del_zad(view: View) {}
    fun back(view: View)
    {
        val intent = Intent(this, CreateAlarmActivity::class.java)
        startActivity(intent)
    }

}

