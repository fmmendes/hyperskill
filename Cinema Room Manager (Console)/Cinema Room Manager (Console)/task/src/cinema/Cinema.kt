package cinema

fun main() {
    println("Enter the number of rows:")
    val rows: Int = readln().toInt()

    println("Enter the number of seats in each row:")
    val seatsPerRow: Int = readln().toInt()

    val income: Int = if (rows * seatsPerRow <= 60) {
        rows * seatsPerRow * 10
    } else {
        val frontSeats = (rows / 2) * seatsPerRow
        val backSeats = ((rows / 2) + (rows % 2)) * seatsPerRow
        (frontSeats * 10) + (backSeats * 8)
    }
    println("Total income:\n$$income")
}

