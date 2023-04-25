package machine

const val WATER_PER_CUP = 200
const val MILK_PER_CUP = 50
const val COFFEE_PER_CUP = 15

fun main() {
    println("Write how many cups of coffee you will need:")

    val cups = readln().toInt()
    val water = cups * WATER_PER_CUP
    val milk = cups * MILK_PER_CUP
    val coffee = cups * COFFEE_PER_CUP

    println("For $cups cups of coffee you will need:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$coffee g of coffee beans")
}
