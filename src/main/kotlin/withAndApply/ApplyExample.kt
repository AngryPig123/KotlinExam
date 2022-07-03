package withAndApply

class ApplyExample {

    fun alphabet(): String = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
    }.toString()

    fun alphabetBuildString(): String = buildString {
        for (letter in 'A'..'Z') {
            append(letter)
        }
    }

}

fun main() {

    val applyTest = ApplyExample()
    applyTest.alphabet().toList().let { System.err.println(it) }
    applyTest.alphabetBuildString().toList().let { System.err.println(it) }

}