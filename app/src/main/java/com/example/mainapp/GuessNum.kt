package com.example.mainapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.mainapp.databinding.ActivityGuessNumBinding


class GuessNum : AppCompatActivity() {
    private lateinit var binding: ActivityGuessNumBinding
    var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityGuessNumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.questionTextView.text = resources.getString(R.string.first_question)
        number = 5

    }
    fun arrDownFunction(view: View?) {
        if (number == 5) {
            number = 3
            binding.questionTextView.text = resources.getString(R.string.second_question)
        } else if (number == 3) {
            number = 2
            binding.questionTextView.text = resources.getString(R.string.third_question)
        } else if (number == 2) {
            number = 1
            binding.questionTextView.text = resources.getString(R.string.fourth_question)
        } else if (number == 7) {
            number = 6
            binding.questionTextView.text = resources.getString(R.string.seventh_question)
        } else if (number == 9) {
            number = 8
            binding.questionTextView.text = resources.getString(R.string.ninth_question)
        }
    }

    fun upArrowFunction(view: View) {
        if (number == 5) {
            number = 7
            binding.questionTextView.text = resources.getString(R.string.sixth_question)
        } else if (number == 7) {
            number = 9
            binding.questionTextView.text = resources.getString(R.string.eight_question)
        } else if (number == 9) {
            number = 10
            binding.questionTextView.text = resources.getString(R.string.ten_question)
        } else if (number == 3) {
            number = 4
            binding.questionTextView.text = resources.getString(R.string.fifth_question)
        }

    }

    fun resetGameFunction(view: View) {
//        binding.questionTextView.visibility=View.VISIBLE
        binding.questionTextView.text = resources.getString(R.string.first_question)

        binding.successTextView.visibility = View.INVISIBLE
        binding.targetedNumber.visibility = View.INVISIBLE
        number=5
        binding.questionTextView.visibility = View.VISIBLE
    }

//    fun successArrowFunction(view: View) {
//        binding.successTextView.visibility = View.VISIBLE
//        binding.questionTextView.visibility = View.INVISIBLE
//        binding.targetedNumber.visibility=View.VISIBLE
//        binding.targetedNumber.text =
//            String.format(resources.getString(R.string.target_number_text_view), number)
//    }

    fun succesArrowFunction(view: View) {
        binding.successTextView.visibility = View.VISIBLE
        binding.questionTextView.visibility = View.INVISIBLE
        binding.targetedNumber.visibility=View.VISIBLE
        binding.targetedNumber.text =
            String.format(resources.getString(R.string.target_number_text_view), number)
    }

}