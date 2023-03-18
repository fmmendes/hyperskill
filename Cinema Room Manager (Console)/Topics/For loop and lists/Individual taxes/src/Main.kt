fun main() {
    val companies = readln().toInt()
    val incomes: MutableList<Int> = mutableListOf()
    val taxesPercentage: MutableList<Int> = mutableListOf()

    val taxes: MutableList<Int> = mutableListOf()

    for (i in 0 until companies) {
        incomes.add(readln().toInt())
    }

    for (i in 0 until companies) {
        taxesPercentage.add(readln().toInt())
    }

    for (i in 0 until companies) {
        if (incomes[i] == 0 || taxesPercentage[i] == 0) {
            taxes.add(0)
        } else {
            taxes.add(incomes[i] * taxesPercentage[i])
        }
    }

    println(taxes.indexOf(taxes.maxOrNull()) + 1)
}