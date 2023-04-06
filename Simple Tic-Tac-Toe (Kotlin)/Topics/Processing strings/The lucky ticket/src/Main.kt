fun main() {
    val ticket = readln()
    val firstHalf = ticket.substring(0, 3)
    val secondHalf = ticket.substring(3, 6)
    val firstHalfSum = firstHalf.map { it.digitToInt() }.sum()
    val secondHalfSum = secondHalf.map { it.digitToInt() }.sum()
    print(if (firstHalfSum == secondHalfSum) "Lucky" else "Regular")
}