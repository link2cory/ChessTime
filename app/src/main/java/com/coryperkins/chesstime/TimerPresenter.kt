package com.coryperkins.chesstime

import android.util.Log
import android.view.View
import android.widget.Button

class TimerPresenter(val white_button: Button, val black_button: Button) {
    val updateButtonText: (Long, Button) -> Unit = { value, button -> button.text = formatLongTime(value) }

    val white_timer = ChessTimer(300000, {value -> updateButtonText(value, white_button)}, { black_wins() })
    val black_timer = ChessTimer(300000, {value -> updateButtonText(value, black_button)}, { white_wins() })

    fun onTimerButtonClicked(timer_button: View) {
        Log.d("TimerPresenter", "Timer Button Clicked!")
        if (timer_button == white_button) {
            Log.d("TimerPresenter", "it was the white button")
            // deal with the timers
            white_timer.onPause()
            black_timer.onResume()

            // deal with the views
            white_button.isEnabled = false
            black_button.isEnabled = true

        } else if (timer_button == black_button) {
            Log.d("TimerPresenter", "it was the black button")
            // deal with the timers
            black_timer.onPause()
            white_timer.onResume()

            // deal with the views
            black_button.isEnabled = false
            white_button.isEnabled = true
        }
    }

    private fun black_wins() {}

    private fun white_wins() {}

    private fun formatLongTime(milliseconds: Long): String {
        val minutes = milliseconds / 1000 / 60
        val seconds = milliseconds / 1000 % 60

        return "$minutes:$seconds"
    }
}
