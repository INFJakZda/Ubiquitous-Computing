package com.zdano.pressmebutton

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClic(v: View) {
        var i = 0
        while (i <= 20) {
            try {
                Thread.sleep(10)
                i++
            } catch (e: Exception) {

            }
        }
        statusText.text = "Skończyłem"
    }
}
