fun main() {
    val size: Int = readln().toInt()
    val list: MutableList<Int> = mutableListOf()
    for (i in 0 until size) {
        list.add(readln().toInt())
    }
    val m: Int = readln().toInt()
    val contains: String = if (list.indexOf(m) == -1) {
        "NO"
    } else {
        "YES"
    }
    println(contains)
}