package com.example.mainapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.viewbinding.ViewBinding

import com.example.mainapp.databinding.ActivityBmiCalculatorBinding


class BMI_Calculator : AppCompatActivity() {
    lateinit var binding: ActivityBmiCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            if (binding.weightEditText.text.isNotEmpty() && binding.heightEditText.text.isNotEmpty()) {
                binding.CalculateBMI()
            } else {
                Toast.makeText(this, "enter the needed field", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun ViewBinding.CalculateBMI() {
        val weight = binding.weightEditText.text.toString().toFloat()
        val height = binding.heightEditText.text.toString().toFloat()

        val myBMI = calculate(weight, height)
        binding.bmiTextView.visibility = View.VISIBLE
        binding.bmiTextView.text = myBMI.toString()

        if (myBMI < 18.5) {
            binding.bmiImageView.setImageResource(R.drawable.underweight)
        } else if (myBMI >= 18.5 && myBMI < 24.9) {
            binding.bmiImageView.setImageResource(R.drawable.healthy)
        } else if (myBMI >= 24.9 && myBMI < 29.9) {
            binding.bmiImageView.setImageResource(R.drawable.overweight)
        } else if (myBMI >= 29.9) {
            binding.bmiImageView.setImageResource(R.drawable.obesity)
        }
    }
    fun calculate(weight:Float,height:Float):Float
    {
        val myBMI = weight / (height * height)
        return myBMI
    }

}

//private fun ViewBinding.CalculateBMI() {
//    val weight = binding.weightEditText.text.toString().toFloat()
//    val height = binding.heightEditText.text.toString().toFloat()
//
//    val myBMI = weight / (height * height)
//
//    binding.bmiTextView.text = myBMI.toString()
//
//    if (myBMI < 18.5) {
//        binding.bmiImageView.setImageResource(R.drawable.underweight)
//    } else if (myBMI >= 18.5 && myBMI < 24.9) {
//        binding.bmiImageView.setImageResource(R.drawable.healthy)
//    } else if (myBMI >= 24.9 && myBMI < 29.9) {
//        binding.bmiImageView.setImageResource(R.drawable.overweight)
//    } else if (myBMI >= 29.9) {
//        binding.bmiImageView.setImageResource(R.drawable.obesity)
//    }
//}
