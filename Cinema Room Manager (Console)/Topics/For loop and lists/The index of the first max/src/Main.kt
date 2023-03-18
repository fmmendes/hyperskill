fun main() {
    val size = readln().toInt()
    val list: MutableList<Int> = mutableListOf()
    for (i in 0 until size) {
        list.add(readln().toInt())
    }

    val max = list.maxOrNull()
    val index = list.indexOf(max)
    println(index)
}