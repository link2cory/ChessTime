package com.coryperkins.chesstime

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class TimerActivity : AppCompatActivity() {

    var presenter: TimerPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = TimerPresenter(
            findViewById<Button>(R.id.button_white),
            findViewById<Button>(R.id.button_black)
        )

        findViewById<Button>(R.id.button_white).setOnClickListener {
            presenter?.onTimerButtonClicked(it)
        }

        findViewById<Button>(R.id.button_black).setOnClickListener {
            presenter?.onTimerButtonClicked(it)
        }
    }

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}
