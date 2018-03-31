package com.example.inf127239.myapplication2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLayout.setOnTouchListener { v : View, m: MotionEvent ->
            handleTouch(m)
            true
        }
    }

    private fun handleTouch(m: MotionEvent) {
        val pointerCount = m.pointerCount

        for (i in 0 until pointerCount) {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex
            var actionString: String

            when (action) {
                MotionEvent.ACTION_DOWN -> actionString = "Down"
                MotionEvent.ACTION_UP -> actionString = "Up"
                MotionEvent.ACTION_POINTER_DOWN -> actionString = "Wsk down"
                MotionEvent.ACTION_POINTER_UP -> actionString = "Wsk up"
                MotionEvent.ACTION_MOVE -> actionString = "Ruch"
                else -> actionString = ""
            }
            val touchStatus = "Akcja: $actionString Wspólrzedne: $actionIndex ID: $id X: $x Y: $y"

            if(id == 0)
                textView1.text = touchStatus
            else
                textView2.text = touchStatus
        }
    }
}
