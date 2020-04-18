object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return phrase
                .filter { it !in ":!!&@\$%^&" }
                .toLowerCase()
                .split(" ", ",", ".", "\n")
                .filter { it.isNotEmpty() }
                .map { it.trimStart('\'').trimEnd('\'') }
                .fold(mapOf()) {
            acc, s -> acc.plus(s to acc.getOrElse(s) { 0 } + 1 )
        }
    }
}
