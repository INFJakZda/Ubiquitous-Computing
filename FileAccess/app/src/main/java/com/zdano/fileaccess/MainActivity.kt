package com.zdano.fileaccess

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveClick(v: View) {
        val contacts = Arrays.asList(
                Contact("Darth Vader", "123123444"),
                Contact("Luke Skywalker", "123123999")
        )
        val filename = "contacts.csv"
        val file = OutputStreamWriter(openFileOutput(filename, Context.MODE_PRIVATE))

        for (c in contacts) {
            file.write(c.toCSV())
        }
        file.flush()
        file.close()
        Toast.makeText(this, "Plik został zapisany", Toast.LENGTH_LONG).show()
    }

    fun readClick(v: View) {
        val contacts = ArrayList<Contact>()
        try {
            val filename = "contacts.csv"
            //if FileExists
            val file = InputStreamReader(openFileInput(filename))
            val br = BufferedReader(file)

            var line = br.readLine()
            while(line != null) {
                contacts.add(Contact(line))
                line = br.readLine()
            }
            file.close()
            val count = contacts.size
            Toast.makeText(this, "Wczytano $count kontaktów", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Błąd w odczycie pliku", Toast.LENGTH_LONG).show()
        }
    }
}
