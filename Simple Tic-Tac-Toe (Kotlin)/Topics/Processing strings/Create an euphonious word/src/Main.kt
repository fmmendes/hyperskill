fun main() {
    val word = readln()
    var count = 0
    var vowels = 0
    var consonants = 0
    word.indices.forEach { i ->
        if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u' || word[i] == 'y') {
            vowels++
            consonants = 0
            if (vowels == 3) {
                count++
                vowels = 1
            }
        } else {
            consonants++
            vowels = 0
            if (consonants == 3) {
                count++
                consonants = 1
            }
        }
    }
    println(count)
}