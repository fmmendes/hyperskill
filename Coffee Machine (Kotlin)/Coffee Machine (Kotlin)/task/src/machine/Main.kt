package machine

const val WATER_PER_CUP = 200
const val MILK_PER_CUP = 50
const val COFFEE_PER_CUP = 15

var waterSupply = 0 // ml
var milkSupply = 0 // ml
var coffeeSupply = 0 //g

fun main() {
    startMachine()
    println("Write how many cups of coffee you will need:")
    val neededCups = readln().toInt()

    val water = waterSupply / WATER_PER_CUP
    val milk = milkSupply / MILK_PER_CUP
    val coffee = coffeeSupply / COFFEE_PER_CUP

    val min = minOf(water, milk, coffee)

    if (neededCups == min) {
        println("Yes, I can make that amount of coffee")
    } else if (neededCups < min) {
        println("Yes, I can make that amount of coffee (and even ${min - neededCups} more than that)")
    } else {
        println("No, I can make only $min cups of coffee")
    }
}

fun startMachine() {
    println("Write how many ml of water the coffee machine has:")
    waterSupply = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    milkSupply = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    coffeeSupply = readln().toInt()
}