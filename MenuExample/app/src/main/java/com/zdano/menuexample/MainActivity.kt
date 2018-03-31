package com.zdano.menuexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.graphics.Color.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuRed -> {
                item.isChecked = !item.isChecked
                layoutView.setBackgroundColor(RED)
                return true
            }
            R.id.menuGreen -> {
                item.isChecked = !item.isChecked
                layoutView.setBackgroundColor(GREEN)
                return true
            }
            R.id.menuYellow -> {
                item.isChecked = !item.isChecked
                layoutView.setBackgroundColor(YELLOW)
                return true
            }
            R.id.menuBlue -> {
                item.isChecked = !item.isChecked
                layoutView.setBackgroundColor(BLUE)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
