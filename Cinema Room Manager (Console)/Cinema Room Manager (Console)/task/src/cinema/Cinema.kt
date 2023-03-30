package cinema

var seats: MutableList<MutableList<Char>> = MutableList(1) { MutableList(1) { 'S' } }
var soldSeats: Int = 0
var income: Int = 0

fun main() {
    initialize()
    menu()
}

fun initialize() {
    println("Enter the number of rows:")
    val rows: Int = readln().toInt()

    println("Enter the number of seats in each row:")
    val columns: Int = readln().toInt()

    seats = MutableList(rows) { MutableList(columns) { 'S' } }
}

fun menu() {
    var option: Int
    do {
        println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        option = readln().toInt()

        if (option == 1) showSeats()

        if (option == 2) buyTicket()

        if (option == 3) showStatistics()

    } while (option != 0)
}

fun showSeats() {
    val heading = (1..seats[0].size).toMutableList()
    println("\nCinema:\n  ${heading.joinToString(" ")}")

    seats.indices.forEach { index ->
        println("${index + 1} ${seats[index].joinToString(" ")}")
    }
}

fun buyTicket() {
    println("\nEnter a row number:")
    val selectedRow: Int = readln().toInt()
    println("Enter a seat number in that row:")
    val selectedColumn: Int = readln().toInt()

    if (selectedRow > seats.size || selectedColumn > seats[0].size) {
        println("Wrong input!")
        buyTicket()
        return
    }

    if (seats[selectedRow - 1][selectedColumn - 1] == 'B') {
        println("That ticket has already been purchased!")
        buyTicket()
        return
    }

    val price: Int = getSeatPrice(selectedRow)
    seats[selectedRow - 1][selectedColumn - 1] = 'B'
    soldSeats++
    income += price
    println("Ticket price: \$$price")

}

fun getSeatPrice(row: Int): Int {
    val rows = seats.size
    val columns = seats[0].size

    if (rows * columns <= 60) return 10
    return if ((rows / 2) >= row) 10 else 8
}

fun totalIncome(): Int {
    val rows = seats.size
    val columns = seats[0].size

    val income: Int = if (rows * columns <= 60) {
        rows * columns * 10
    } else {
        val frontSeats = (rows / 2) * columns
        val backSeats = ((rows / 2) + (rows % 2)) * columns
        (frontSeats * 10) + (backSeats * 8)
    }
    return income
}

fun showStatistics() {
    val rows = seats.size
    val columns = seats[0].size

    val percentage = soldSeats.toDouble() / (rows * columns) * 100
    val formatPercentage = "%.2f".format(percentage)

    println("Number of purchased tickets: $soldSeats")
    println("Percentage: $formatPercentage%")
    println("Current income: \$$income")
    println("Total income: \$${totalIncome()}")
}
