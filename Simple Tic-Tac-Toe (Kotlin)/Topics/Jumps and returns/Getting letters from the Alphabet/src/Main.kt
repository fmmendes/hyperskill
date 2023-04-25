fun main() {
    val letter = readln().toCharArray()[0]
    val letters = getLetters(letter)
    println(letters)
}

fun getLetters(letter: Char): String {
    val letters = mutableListOf<Char>()

    for (i in 'a' until letter) {
        letters.add(i)
    }

    return letters.joinToString("")
}