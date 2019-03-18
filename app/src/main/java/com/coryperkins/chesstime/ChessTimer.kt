package com.coryperkins.chesstime

import android.os.CountDownTimer
import android.util.Log

class ChessTimer(initial: Long, val onRemainingChanged: (Long) -> Unit, val onFinished: () -> Unit) {
    var countdown: CountDownTimer? = null
    var remaining: Long = initial
        private set(value) {
            onRemainingChanged(value)
            field = value
        }


    fun onResume() {
        Log.d("ChessTimer", "starting a new timer with $remaining milliseconds")
        countdown = object: CountDownTimer(remaining, 1000) {
            override fun onTick(millisUntilFinished: Long) {
//                Log.d("ChessTimer", "1000 milliseconds have elapsed, time remaining is: $millisUntilFinished")
                remaining = millisUntilFinished
            }

            override fun onFinish() {
                onFinished()
            }
        }.start()
    }

    fun onPause() {
        countdown?.cancel()
    }
}
