package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDate = findViewById<Button>(R.id.btnDatePicker)

        buttonDate.setOnClickListener{ view ->
            clickDatePicker(view)
        }

    }

    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                Toast.makeText(this, "Date Selected.", Toast.LENGTH_SHORT).show()

            }
            ,year
            ,month
            ,day).show()
    }

}