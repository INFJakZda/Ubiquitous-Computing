package com.zdano.broadcastexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.view.View

class SendBroadcastActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_broadcast)
        configureReceiver()
    }

    fun broadcastIntent(view: View) {
        val intent = Intent()
        intent.action = "com.zdano.sendbroadcast"
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("com.zdano.sendbroadcast")
        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}
