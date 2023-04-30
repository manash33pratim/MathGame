package com.manash.mathgame

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast



import kotlin.random.Random

class Add : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textLife : TextView

    lateinit var textQuestion : TextView
    lateinit var editTextAnswer : EditText

    lateinit var buttonOk : Button
    lateinit var buttonNext : Button
    lateinit var answerView: TextView

    var correctAnswer = 0
    var userScore = 0
    var userLife = 3
    var number1=0
    var number2=0






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add)

        supportActionBar!!.title = "Addition"

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewlife)
        textQuestion = findViewById(R.id.textViewQuestion)
        editTextAnswer = findViewById(R.id.editTextAnswer)
        buttonOk = findViewById(R.id.buttonOK)
        buttonNext = findViewById(R.id.buttonNext)
        answerView=findViewById(R.id.answerView)




        gameContinue()

        buttonOk.setOnClickListener {

            val input = editTextAnswer.text.toString()

            if(input == ""){
                Toast.makeText(applicationContext,"Please write an answer or click the next button",Toast.LENGTH_LONG).show()
            }
            else{
                val userAnswer = input.toInt()
                if (userAnswer == correctAnswer){
                    userScore += 10
                    textQuestion.text = "Congratulation! \nYour answer is correct"
                    buttonOk.visibility= View.INVISIBLE
                    textScore.text = userScore.toString()
                    buttonNext.text="NEXT"


                }
                else{
                    textQuestion.text = "Sorry! Your answer is \nwrong"
                    buttonOk.visibility= View.INVISIBLE
                    textLife.text = userLife.toString()
                    userLife--
                    answerView.text="Correct Answer is \n   $number1+$number2=$correctAnswer"
                    textLife.text = userLife.toString()
                    buttonNext.text="NEXT"
                }

            }

        }
        buttonNext.setOnClickListener {
            answerView.text=""
            gameContinue()

            editTextAnswer.setText("")
            buttonOk.visibility= View.VISIBLE

            val input = editTextAnswer.text.toString()
            if (input == "" ){


            }
            if (userLife == 0){
                Toast.makeText(applicationContext,"Game Over",Toast.LENGTH_LONG).show()
                val ip=intent.getStringExtra("name")

                Toast.makeText(this, ip, Toast.LENGTH_SHORT).show()
                val i = Intent(this,ResultActivity::class.java)

                i.putExtra("score",userScore)
                i.putExtra("name",ip)
               startActivity(i)
               finish()

            }
            else

                gameContinue()

            }


        }

    fun gameContinue(){
         number1 = Random.nextInt(0,100)
         number2 = Random.nextInt(0,100)
        buttonNext.text="SKIP"
        textQuestion.text = "$number1 + $number2"
        correctAnswer = number1 + number2


    }
    fun customExitDialog() {
        // creating custom dialog
        val dialog = Dialog(this@Add)

        // setting content view to dialog
        dialog.setContentView(R.layout.custom_exit_dialog)

        // getting reference of TextView
        val dialogButtonYes = dialog.findViewById(R.id.textViewYes) as TextView
        val dialogButtonNo = dialog.findViewById(R.id.textViewNo) as TextView

        // click listener for No
        dialogButtonNo.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //dismiss the dialog
                dialog.dismiss()
            }
        })

        // click listener for Yes
        dialogButtonYes.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // dismiss the dialog
                // and exit the exit
                dialog.dismiss()

                val ip=intent.getStringExtra("name")
                val i=Intent(applicationContext,ResultActivity::class.java)


                i.putExtra("score",userScore)
                i.putExtra("name",ip)
                startActivity(i)
                finish()
            }
        })

        // show the exit dialog
        dialog.show()
    }

    override fun onBackPressed() {
        // calling the function
        customExitDialog()
    }




}