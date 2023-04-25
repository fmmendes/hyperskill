package tictactoe

import kotlin.math.abs

const val GRID_SIZE = 3
val gameGrid = MutableList(GRID_SIZE) { MutableList(GRID_SIZE) { ' ' } }
var currentTurn = 'X'

fun main() {
    printGrid(gameGrid)

    while (analyzeGame()){
        makeMove()
        printGrid(gameGrid)
    }
}

/**
 * Analyze the game state and print the result. Possible states:
 * Game not finished when neither side has three in a row but the grid still has empty cells.
 * Draw when no side has a three in a row and the grid has no empty cells.
 * X wins when the grid has three X’s in a row (including diagonals).
 * O wins when the grid has three O’s in a row (including diagonals).
 * Impossible when the grid has three X’s in a row as well as three O’s in a row, or there are a lot more X's than O's or vice versa (the difference should be 1 or 0; if the difference is 2 or more, then the game state is impossible).
 */
fun analyzeGame(): Boolean {
    // Check if the game is impossible
    val xCount = gameGrid.flatten().count { it == 'X' }
    val oCount = gameGrid.flatten().count { it == 'O' }
    val xWins = checkWin(gameGrid, 'X')
    val oWins = checkWin(gameGrid, 'O')
    if (abs(xCount - oCount) > 1 || (xWins && oWins)) {
        println("Impossible")
        return false
    }

    // Check if X wins
    if (xWins) {
        println("X wins")
        return false
    }

    // Check if O wins
    if (oWins) {
        println("O wins")
        return false
    }

    // Draw when no side has a three in a row and the grid has no empty cells.
    if (gameGrid.flatten().none { it == ' ' }) {
        println("Draw")
        return false
    }

    // Game not finished when neither side has three in a row but the grid still has empty cells.
    return gameGrid.flatten().any { it == ' ' }
}

fun makeMove() {
    var input = readln()
    while (true) {
        if (!input.matches(Regex("\\d\\s\\d"))) {
            println("You should enter numbers!")
            input = readln()
            continue
        }

        val x = input[0].digitToInt()
        val y = input[2].digitToInt()

        if (x !in 1..3 || y !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            input = readln()
            continue
        }

        if (gameGrid[x - 1][y - 1] != ' ') {
            println("This cell is occupied! Choose another one!")
            input = readln()
            continue
        }

        gameGrid[x - 1][y - 1] = currentTurn
        break
    }

    // Switch the turn
    currentTurn = if (currentTurn == 'X') 'O' else 'X'
}

fun printGrid(gridInput: MutableList<MutableList<Char>>) {
    println("---------")
    gridInput.indices.forEach { index ->
        println("| ${gridInput[index].joinToString(" ")} |")
    }
    println("---------")
}

fun checkWin(gridInput: MutableList<MutableList<Char>>, c: Char): Boolean {
    // Check the rows
    gridInput.forEach { it -> if (it.all { it == c }) return true }

    // Check the columns
    gridInput[0].indices.forEach { index ->
        if (gridInput.all { it[index] == c }) return true
    }

    // Check the diagonals
    if (gridInput[0][0] == c && gridInput[1][1] == c && gridInput[2][2] == c) return true
    return gridInput[0][2] == c && gridInput[1][1] == c && gridInput[2][0] == c
}
