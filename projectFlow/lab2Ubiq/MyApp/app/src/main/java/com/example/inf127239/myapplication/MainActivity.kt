package com.example.inf127239.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pressMeButton.setOnClickListener {
            //statusText.text = "Nacisnieto"
        //}
        pressMeButton.setOnLongClickListener {
            statusText.text = "Dlugie wcisniecie"
            true
        }

        fun naClick(v: View) {
            var i = 0
            while (i <= 20) {
                try {
                    Thread.sleep(1000)
                    i++
                } catch (e: Exception) {

                }
            }
            statusText.text = "click"
        }
    }


}
