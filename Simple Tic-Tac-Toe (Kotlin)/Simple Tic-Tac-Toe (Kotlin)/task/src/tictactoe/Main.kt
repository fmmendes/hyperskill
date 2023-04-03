package tictactoe

fun main() {
    val gridInput: MutableList<MutableList<Char>> =
        readln().chunked(3).map { it.toMutableList() } as MutableList<MutableList<Char>>

    println("---------")
    gridInput.indices.forEach {index ->
        println("| ${gridInput[index].joinToString(" ")} |")
    }
    println("---------")
}