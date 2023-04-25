fun countUniqueChars(sequence: CharSequence): Int {
    val seen = mutableSetOf<Char>()
    for (element in sequence) {
        if (element !in seen) {
            seen.add(element)
        }
    }
    return seen.size
}