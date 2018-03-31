package com.example.inf127239.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun myButtonClick (v: View) {
        statusText.text = "Uruchamiam"
        showActivity()
    }

    fun showActivity() {
        val i = Intent(this, SecondActivity::class.java)
        i.putExtra("Parametr", "Twoje dane")
        startActivityForResult(i, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)) {
            if(data != null) {
                if(data.hasExtra("returnString1")) {
                    statusText.text = data.extras.getString("returnString1")
                }
            }
        }
    }

    fun showImpicitActivity() {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.predki.com"))
        startActivity(i)
    }
}
