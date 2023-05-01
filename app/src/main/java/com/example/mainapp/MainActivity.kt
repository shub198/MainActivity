package com.example.mainapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.view.View
import com.example.mainapp.R.id.listViewButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1:Button=findViewById(R.id.btn_to_guess_num)
        val button2:Button=findViewById(R.id.btn_Calculator)
        val button3:Button=findViewById(R.id.bmi_calculator_btn)
        val button4:Button=findViewById((R.id.listViewButton))


        button1.setOnClickListener(){

            var intent=Intent(this,GuessNum::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener(){

            var intent1=Intent(this,Calculator::class.java)
            startActivity(intent1)
        }
        button3.setOnClickListener(){

            var intent2=Intent(this,BMI_Calculator::class.java)
            startActivity(intent2)
        }
        button4.setOnClickListener(){
            var intent4 = Intent(this,ListView::class.java)
            startActivity(intent4)
        }
    }
}