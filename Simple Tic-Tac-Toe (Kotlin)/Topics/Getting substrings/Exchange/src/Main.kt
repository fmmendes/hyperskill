fun main() {
    val input = readln()
    val first = input[0]
    val last = input[input.length - 1]
    val middle = input.substring(1, input.length - 1)
    println(last + middle + first)
}