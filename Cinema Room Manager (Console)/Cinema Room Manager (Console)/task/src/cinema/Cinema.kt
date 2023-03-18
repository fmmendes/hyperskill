package cinema

var seats: MutableList<MutableList<Char>> = MutableList(1) { MutableList(1) { 'S' } }

fun showSeats() {
    val heading = (1..seats[0].size).toMutableList()
    println("\nCinema:\n  ${heading.joinToString(" ")}")

    seats.indices.forEach { index ->
        println("${index + 1} ${seats[index].joinToString(" ")}")
    }
}

fun getSeatPrice(row: Int): Int {
    val rows = seats.size
    val columns = seats[0].size

    return if (rows * columns <= 60 || row <= (rows / 2)) {
        10
    } else 8
}

fun totalIncome() {
    val rows = seats.size
    val columns = seats[0].size

    val income: Int = if (rows * columns <= 60) {
        rows * columns * 10
    } else {
        val frontSeats = (rows / 2) * columns
        val backSeats = ((rows / 2) + (rows % 2)) * columns
        (frontSeats * 10) + (backSeats * 8)
    }
    println("Total income:\n$$income")
}

fun initialize() {
    println("Enter the number of rows:")
    val rows: Int = readln().toInt()

    println("Enter the number of seats in each row:")
    val columns: Int = readln().toInt()

    seats = MutableList(rows) { MutableList(columns) { 'S' } }
}

fun main() {
    initialize()
    menu()
}

fun chooseSeat() {
    println("\nEnter a row number:")
    val selectedRow: Int = readln().toInt()
    println("Enter a seat number in that row:")
    val selectedColumn: Int = readln().toInt()

    seats[selectedRow - 1][selectedColumn - 1] = 'B'
    val price: Int = getSeatPrice(selectedRow)
    println("Ticket price: \$$price")

}

fun menu() {
    var option: Int
    do {
        println("\n1. Show the seats\n2. Buy a ticket\n0. Exit")
        option = readln().toInt()

        if (option == 1) {
            showSeats()
        }

        if (option == 2) {
            chooseSeat()
        }
    } while (option != 0)
}

