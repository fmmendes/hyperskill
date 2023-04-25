fun main() {
    val word = readln()
    val unusedLetters = mutableListOf<Char>()
    for (letter in 'a'..'z') {
        if (letter !in word) {
            unusedLetters.add(letter)
        }
    }
    println(unusedLetters.joinToString(""))
}
