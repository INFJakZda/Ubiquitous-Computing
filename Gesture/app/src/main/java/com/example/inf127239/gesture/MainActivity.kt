package com.example.inf127239.gesture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.GestureDetector
import android.support.v4.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var qDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.qDetector = GestureDetectorCompat(this, this)
        qDetector?.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        this.qDetector?.onTouchEvent(event)

        return super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        statusText.text = "onDown"
        return true
    }

    override fun onFling(event1: MotionEvent, event2: MotionEvent, velocity1: Float, velocity2: Float): Boolean {
        statusText.text = "onFling"
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        statusText.text = "LongPress"
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        statusText.text = "Scroll"
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {
        statusText.text = "ShowPress"
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        statusText.text = "SingleTap"
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        statusText.text = "DoubleTap"
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        statusText.text = "DoubleTapEvent"
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        statusText.text = "SingletAPcONFIRMED"
        return true
    }
}
