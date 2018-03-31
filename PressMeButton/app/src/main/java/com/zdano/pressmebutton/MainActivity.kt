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

    private var task = MyTask()
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private inner class MyTask : AsyncTask<String, Int, String>() {

        override fun onPreExecute() {
            running = true
            statusText.text = "Zaczynam"
            pressMeButton.text = "Anuluj"
            Log.i("As", "PreExecute")
        }

        override fun doInBackground(vararg p0: String?): String {
            Log.i("As", "Zaczynam")
            var i = 0
            while (i <= 5) {
                try {
                    Thread.sleep(1000)
                    if (isCancelled()) {
                        Log.i("As", "Przerywam")
                        return "Anulowałeś mnie"
                    }
                    publishProgress(i)
                    i++
                } catch (e: Exception) {
                    return(e.localizedMessage)
                }
            }
            Log.i("As", "Kończę")
            return "Skończyłem"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val counter = values.get(0)
            statusText.text = "Licznik =  $counter"
            Log.i("As", "Update")
        }

        override fun onPostExecute(result: String) {
            statusText.text = result
            running = false
            pressMeButton.text = "Naciśnij mnie"
            Log.i("As", "Skończyłem")
        }

        override fun onCancelled(result: String?) {
            Log.i("As", "Zaczynam anulować")
            super.onCancelled(result)
            pressMeButton.text = "Anulowane"
            Log.i("As", "Anulowane")
            running = false
        }
    }

    fun onClic(v: View) {
        if(running) {
            Log.i("As", "Guzik anuluje")
            task.cancel(false)
        }
        else {
            Log.i("As", "Uruchamiam")
            task = MyTask()
            task.execute()
        }
    }
}
