package com.mdapp.game2048mdapp

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class TouchListener(
    private val touchCallback: (Direction) -> Unit,
) : View.OnTouchListener {

    private var startX = 0f
    private var startY = 0f
    private var offsetX = 0f
    private var offsetY = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = motionEvent.x
                startY = motionEvent.y
            }
            MotionEvent.ACTION_UP -> {
                offsetX = motionEvent.x - startX
                offsetY = motionEvent.y - startY
                if (abs(offsetX) > abs(offsetY)) {
                    if (offsetX < -5) {
                        touchCallback(Direction.LEFT)
                    } else if (offsetX > 5) {
                        touchCallback(Direction.RIGHT)
                    }
                } else {
                    if (offsetY < -5) {
                        touchCallback(Direction.UP)
                    } else if (offsetY > 5) {
                        touchCallback(Direction.DOWN)
                    }
                }
            }
        }
        return true
    }
}