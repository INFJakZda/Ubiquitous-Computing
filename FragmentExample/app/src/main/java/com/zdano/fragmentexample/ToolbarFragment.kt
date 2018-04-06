package com.zdano.fragmentexample

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.toolbar_layout.*
import java.text.FieldPosition

class ToolbarFragment: Fragment(), SeekBar.OnSeekBarChangeListener {

    var seekValue = 10
    var activityCallback: ToolbarFragment.ToolbarListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.toolbar_layout, container, false)
        val seekBar: SeekBar? = view?.findViewById(R.id.seekBar1)
        val button: Button? = view?.findViewById(R.id.button1)
        seekBar?.setOnSeekBarChangeListener(this)
        button?.setOnClickListener{ v: View -> buttonClicked(v)}
        return view
    }

    interface ToolbarListener {
        fun onButtonClick(position: Int, text: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        } catch (c: ClassCastException) {
            throw ClassCastException(context?.toString() + " musi implementować interfejs")
        }
    }

    private fun buttonClicked(view: View) {
        activityCallback?.onButtonClick(seekValue, editText1.text.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekValue = progress
    }

    override fun onStartTrackingTouch(seekArg: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekArg: SeekBar?) {
    }
}