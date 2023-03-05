package cinema

const val ROWS: Int = 7
const val COLUMNS: Int = 8

fun main() {
    println("Cinema:")
    for (row in 0..ROWS) {
        for (column in 0..COLUMNS) {
            if (row == 0 && column == 0) print(' ')
            if (row == 0 && column != 0) print(column)
            if (row != 0 && column == 0) print(row)
            if (row != 0 && column != 0) print('S')
            print(' ')
            if (column == COLUMNS) print('\n')
        }
    }
}