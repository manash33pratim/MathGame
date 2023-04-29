package com.manash.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.manash.mathgame.databinding.ActivityMainBinding
import com.manash.mathgame.fragment.Fragment1


class MainActivity : AppCompatActivity() {
    lateinit var addition : ImageButton

        lateinit var subtraction : ImageButton
    lateinit var multi : ImageButton
    lateinit var div : ImageButton
    lateinit var table: ImageButton





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition = findViewById(R.id.buttonAdd)
        subtraction = findViewById(R.id.buttonSub)
        multi = findViewById(R.id.buttonMulti)
        div= findViewById(R.id.buttondiv)
        table=findViewById(R.id.table)


        //---------------------------------------------------




        //-------------------------------------



        //--------------------------------------------------------------
        addition.setOnClickListener {

            val intent = Intent(this@MainActivity,Add::class.java)
            startActivity(intent)
           // finish()

        }
        subtraction.setOnClickListener {

            val intent = Intent(this@MainActivity,Minus::class.java)
            startActivity(intent)
           // finish()

        }
        multi.setOnClickListener {

            val intent = Intent(this@MainActivity,Multi::class.java)
            startActivity(intent)
           // finish()

        }
        div.setOnClickListener {
            val intent = Intent(this@MainActivity,Divide::class.java)
            startActivity(intent)
            //finish()
        }
        table.setOnClickListener {
            val intent = Intent(this@MainActivity,MultiTable::class.java)
            startActivity(intent)
        }



    }

}