fun main() {
    val n = readln().toInt()
    val list = MutableList(n) { readln().toInt() }
    val shift = readln().toInt() % n
    for (i in 1..shift) {
        val temp = list[n - 1]
        for (j in n - 1 downTo 1) {
            list[j] = list[j - 1]
        }
        list[0] = temp
    }
    println(list.joinToString(" "))
}