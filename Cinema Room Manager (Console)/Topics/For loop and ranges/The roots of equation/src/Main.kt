import kotlin.math.pow

fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()

    for (x in 0..1000) {
        val xCubic = x.toDouble().pow(3)
        val xSquare = x.toDouble().pow(2)
        val equation = a * xCubic + b * xSquare + c * x + d
        if (equation == 0.0) println(x)
    }
}