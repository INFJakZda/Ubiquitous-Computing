package com.example.inf127239.myapplication

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extras = intent.extras ?: return
        val message = extras.getString("Parametr")
        statusText.text = message
    }

    override fun finish() {
        val data = Intent()

        data.putExtra("returnString1", "Wiadomosc dla ciebie")
        setResult(Activity.RESULT_OK, data)

        super.finish()
    }
}
