import kotlin.math.sqrt

const val PI = 3.14

fun triangleArea(a: Double, b: Double, c: Double): Double {
    val s = (a + b + c) / 2.0
    return sqrt(s * (s - a) * (s - b) * (s - c))
}

fun rectangleArea(a: Double, b: Double): Double {
    return a * b
}

fun circleArea(r: Double): Double {
    return PI * r * r
}

fun main() {
    println(
        when (readln()) {
            "triangle" -> triangleArea(readln().toDouble(), readln().toDouble(), readln().toDouble())
            "rectangle" -> rectangleArea(readln().toDouble(), readln().toDouble())
            "circle" -> circleArea(readln().toDouble())
            else -> ""
        }
    )
}