package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){

        tvInput.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View){

        tvInput.text = ""
        lastNumeric = false
        lastDot = false


    }

    fun onDecimalPoint(view: View){
        if (lastNumeric && !lastDot){
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onEqual(view: View){
        if(lastNumeric){
            var tvValue = tvInput.text.toString()
             var prefix = ""

            try {

                // We check if we have a minus at the beggining
                if(tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)

                }

                if(tvValue.contains("-")){
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    // Check if it is empty or if we have a second minus
                    if(!prefix.isEmpty()){
                        one = prefix + one
                    }


                    tvInput.text = (one.toDouble() + two.toDouble()).toString()
                }
            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    fun onOperator(view: View){
        if(lastNumeric && !isOperatorAdded(tvInput.toString())){
            tvInput.append((view as Button).text)
            lastNumeric = false
        }
    }

    private fun isOperatorAdded(value: String) : Boolean {
        return if (value.startsWith("-")){
           false
        } else  value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
    }
}