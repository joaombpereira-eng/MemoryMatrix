package com.firstapp.memorymatrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            val toGuess = MatrixPattern.fromRandom(7, matrixView.widthInTiles)
            val view = MatrixPatternView(matrixView, toGuess)
            view.draw()
        }
    }
}