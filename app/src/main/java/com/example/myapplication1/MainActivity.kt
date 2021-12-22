package com.example.myapplication1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnleft = findViewById<Button>(R.id.btn1)
        val btnright = findViewById<Button>(R.id.btn2)


        btnleft.setOnClickListener {
            checkanswer(true)
            assignnumber()
        }
        btnright.setOnClickListener {
            checkanswer(false)
            assignnumber()
        }

    }

    private fun checkanswer(isLeftButtonSelected: Boolean) {
        val btnleft = findViewById<Button>(R.id.btn1)
        val btnright = findViewById<Button>(R.id.btn2)
        val background = findViewById<ConstraintLayout>(R.id.constlay)
        val numleft = btnleft.text.toString().toInt()
        val numright = btnright.text.toString().toInt()
        val isAnswerCorrect = if(isLeftButtonSelected) numleft > numright else numright > numleft
        if( isAnswerCorrect) {
            background.setBackgroundColor(Color.GREEN)
            Toast.makeText(this,"correct", Toast.LENGTH_SHORT).show()
        }
        else{
            background.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Incorrect", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignnumber() {
        val r= Random()
        val leftNum = r.nextInt(10)
        val rightNum = r.nextInt(10)
        while(rightNum == leftNum){
            r.nextInt(10)
        }
        val btnleft = findViewById<Button>(R.id.btn1)
        val btnright = findViewById<Button>(R.id.btn2)
        btnleft.text = leftNum.toString()
        btnright.text= rightNum.toString()



    }
}