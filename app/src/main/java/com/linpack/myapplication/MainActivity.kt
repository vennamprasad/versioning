package com.linpack.myapplication

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_1.setOnEditorActionListener(this)
        et_2.setOnEditorActionListener(this)
        bt_add.setOnClickListener {
            when {
                et_1.text.toString().trim() == "" -> {
                    et_1.error = "error"
                }
                et_2.text.toString().trim() == "" -> {
                    et_2.error = "error"
                }
                else -> {
                    tv_result.text =
                        (et_1.text.toString().toInt().plus(et_2.text.toString().toInt())).toString()
                }
            }
        }
        bt_clear.setOnClickListener {
            et_1.setText("")
            et_1.error = ""
            et_2.setText("")
            et_2.error = ""
            tv_result.text = ""
            et_1.requestFocus()
        }
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            bt_add.callOnClick()
            return true
        }
        return false
    }
}