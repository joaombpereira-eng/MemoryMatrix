package com.firstapp.memorymatrix

import pt.isel.poo.tile.TilePanel

fun TilePanel.clear(): Unit {
    for (x in 0 until widthInTiles)
        for (y in 0 until heightInTiles){
            setTile(x, y, null)
        }
}

class MatrixPatternView(
    private val matrixView: TilePanel,
    private val model: MatrixPattern) {

    fun draw() {
        matrixView.clear()
        model.forEach {
            matrixView.setTile(it.x,it.y, PatternElementTile())
        }

    }
}
