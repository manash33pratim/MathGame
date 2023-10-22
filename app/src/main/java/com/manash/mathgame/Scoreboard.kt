package com.manash.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView


class Scoreboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scoreboard)
        val savedFiles = applicationContext.fileList()
        savedFiles.reverse()
        val lv = findViewById<ListView>(R.id.list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, savedFiles)
        lv.adapter = adapter
        lv.setOnItemClickListener { parent, view, position, id ->
            val intValue = id.toInt()
            val item = lv.getItemAtPosition(intValue).toString()
            val intent = Intent(this, ScoreboardResult::class.java)


            val bundle = Bundle()
            bundle.putString("myKey", item)

            intent.putExtras(bundle)

            startActivity(intent)
            finish()
    }

        val home=findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()}


    }
    }

