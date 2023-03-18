fun main() {
    val a: Int = readln().toInt()
    val b: Int = readln().toInt()

    var sum: Int = 0
    for (i in a..b) {
        sum += i
    }
    println(sum)
}