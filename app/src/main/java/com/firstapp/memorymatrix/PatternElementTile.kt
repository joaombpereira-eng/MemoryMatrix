package com.firstapp.memorymatrix

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import pt.isel.poo.tile.Tile

const val MARGIN = 15f

class PatternElementTile : Tile {

    private val brush: Paint = Paint().apply {
        color = Color.parseColor("#AA8BC2")
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 11f
    }

    override fun draw(canvas: Canvas?, side: Int) {
            canvas?.drawRect(
                MARGIN,MARGIN, side.toFloat()- MARGIN, side.toFloat()- MARGIN, brush)
    }

    override fun setSelect(selected: Boolean) = false

}