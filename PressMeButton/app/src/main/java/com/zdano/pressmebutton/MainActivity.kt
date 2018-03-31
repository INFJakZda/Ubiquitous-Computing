package com.zdano.pressmebutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pressMeButton.setOnClickListener {
            statusText.text = "Nacisnieto"
        }
        pressMeButton.setOnLongClickListener {
            statusText.text = "Dlugie wcisniecie"
            true
        }
    }


}
