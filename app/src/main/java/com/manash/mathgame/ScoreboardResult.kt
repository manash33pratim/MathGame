package com.manash.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.io.File

class  ScoreboardResult : AppCompatActivity() {
    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scoreboard_result)


        tv = findViewById(R.id.tvresult)
        val bundle = intent.extras
        val myVariable = bundle?.getString("myKey")


        val file = myVariable
        val fin = openFileInput(file)

        var c: Int
        var temp = ""
        while (fin.read().also { c = it } != -1) {
            temp += c.toChar().toString()
        }
        val arr = temp.split(",")
        //tv.text=file.toString()
        tv.text = arr[0]
//        tv2.text =arr[1]
//        tv3.text=arr[2]
//        tv4.text=arr[3]
//        tv5.text=arr[4]
//        tv6.text=arr[5]
//        tv7.text=arr[6]

        // val context = applicationContext

        val deleteButton = findViewById<Button>(R.id.deletebtn)
        val del = File(applicationContext.filesDir, myVariable)
        //Toast.makeText(this, myVariable, Toast.LENGTH_SHORT).show()
        deleteButton.setOnClickListener {
            if (del.exists()) {
                  del.delete()
                val intent = Intent(this, Scoreboard::class.java)
                startActivity(intent)
                finish()
            }
        }
    }}