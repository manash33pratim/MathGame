package com.manash.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.*


class ResultActivity : AppCompatActivity() {

    lateinit var result : TextView
    lateinit var playAgain : Button
    lateinit var exit : Button
    lateinit var tv: TextView
    lateinit var data:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tv=findViewById(R.id.textView5)
        result = findViewById(R.id.textViewResult)
        playAgain = findViewById(R.id.buttonAgain)
        exit = findViewById(R.id.buttonExit)


        val name=intent.getStringExtra("name")
        val score = intent.getIntExtra("score",0)

        if(score==0){
            tv.setText("Opps..")
        }else{
            tv.setText("Congratulations")
        }
            result.text =name+ " your score is : " + score
     //adding------------------------------DELETE-----------------
        val del = File(applicationContext.filesDir, name)

            if (del.exists()) {
                del.delete()
   //------------------------------------add----------------------------
                val file: String = name.toString()

                data = score.toString()



                try {
                    val fout = openFileOutput(file, MODE_APPEND)
                    fout.write(data.toByteArray())
                    fout.close()
                    Toast.makeText(this, "file saved", Toast.LENGTH_LONG).show()
                } catch (to: IOException) {

                }
            }else{
                val file:String = name.toString()

                data= score.toString()


                try{
                    val fout = openFileOutput(file, MODE_APPEND)
                    fout.write(data.toByteArray())
                    fout.close()
                    Toast.makeText(this,"file saved",Toast.LENGTH_LONG).show()
                }
                catch (to: IOException){

             }
            }


//-------------------------------------------------------

        playAgain.setOnClickListener {





            val intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        exit.setOnClickListener {

            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

        }
    }
}