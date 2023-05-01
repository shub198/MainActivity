package com.example.mainapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }
    var number:String=""
    var numberOne:Float=0.0F
    var numberTwo:Float=0.0F
    var isAdd:Boolean=false
    var isDivide:Boolean=false
    var isMin:Boolean=false

    fun operationFun(view: View){
        var edittext: EditText? = findViewById(R.id.edit_text)
        when(view.id){
            R.id.button_1 ->{
                number +="1"
                edittext?.setText(number)
            }
            R.id.button_2 ->{
                number +="2"
                edittext?.setText(number)
            }
            R.id.button_3 ->{
                number +="3"
                edittext?.setText(number)
            }
            R.id.button_4 ->{
                number +="4"
                edittext?.setText(number)
            }
            R.id.button_5 ->{
                number +="5"
                edittext?.setText(number)
            }
            R.id.button_6 ->{
                number +="6"
                edittext?.setText(number)
            }
            R.id.button_7 ->{
                number +="7"
                edittext?.setText(number)
            }
            R.id.button_8 ->{
                number +="8"
                edittext?.setText(number)
            }
            R.id.button_9 ->{
                number +="9"
                edittext?.setText(number)
            }
            R.id.button_0 ->{
                number +="0"
                edittext?.setText(number)
            }
            R.id.button_C ->{
                number=""
                edittext?.setText(number)
            }
            R.id.button_Dot ->{
                number +="."
                edittext?.setText(number)
            }
            R.id.button_Plus ->{
                if(number.isNullOrBlank())
                    edittext?.setText("")
                else{
                    numberOne=number.toFloat()
                    edittext?.setText("")
                    isAdd=true
                    number=""
                }
            }
            R.id.button_Divide ->{
                if(number.isNullOrBlank())
                    edittext?.setText("")
                else{
                    numberOne=number.toFloat()
                    edittext?.setText("")
                    isDivide=true
                    number=""
                }
            }
            R.id.button_Minus ->{
                if(number.isNullOrBlank())
                    edittext?.setText("")
                else{
                    numberOne=number.toFloat()
                    edittext?.setText("")
                    isMin=true
                    number=""
                }
            }
            R.id.button_Equal ->{
                if(isAdd == true){
                    numberTwo= number.toFloat()
                    edittext?.setText((numberOne+numberTwo).toString())
                }
                else if(isDivide==true){
                    numberTwo = number.toFloat()
                    edittext?.setText((numberOne/numberTwo).toString())
                }
                else if(isMin==true){
                    numberTwo = number.toFloat()
                    edittext?.setText((numberOne-numberTwo).toString())
                }
            }
        }
    }
}