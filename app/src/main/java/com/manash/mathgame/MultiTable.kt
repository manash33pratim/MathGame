package com.manash.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

import android.widget.RadioGroup

import androidx.fragment.app.Fragment
import com.manash.mathgame.fragment.*

class MultiTable : AppCompatActivity() {

    lateinit var rgrp: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_table)
        replaceFragment(Fragment1())
        rgrp=findViewById(R.id.rgrp)
        val homebtn=findViewById<ImageButton>(R.id.homebutton)
        rgrp.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.first -> {
                    // switch to fragment 1
                    replaceFragment(Fragment1())
                }
                R.id.second -> {

                    replaceFragment(Fragment2())
                }
                R.id.third -> {
                    // Fragment 3
                    replaceFragment(Fragment3())
                }
                R.id.fourth -> {
                    // Fragment 3
                    replaceFragment(Fragment4())
                }
                R.id.fifth -> {
                    // Fragment 3
                    replaceFragment(Fragment5())
                }
                R.id.sixth -> {
                    // Fragment 3
                    replaceFragment(Fragment6())
                }
                R.id.seventh -> {
                    // Fragment 3
                    replaceFragment(Fragment7())
                }
                R.id.eightth -> {
                    // Fragment 3
                    replaceFragment(Fragment8())
                }
                R.id.ninth -> {
                    // Fragment 3
                    replaceFragment(Fragment9())
                }
                R.id.tenth -> {
                    // Fragment 3
                    replaceFragment(Fragment10())
                }
                R.id.eleven -> {
                    // Fragment 3
                    replaceFragment(Fragment11())
                }
                R.id.twelve -> {
                    // Fragment 3
                    replaceFragment(Fragment12())
                }
            }
        }


        //-----------------
homebtn.setOnClickListener {
    val int=Intent(this,MainActivity::class.java)
    startActivity(int)
    finish()
}
    }
    fun  replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition= fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentdisplay,fragment)
        fragmentTransition.commit()
    }
}