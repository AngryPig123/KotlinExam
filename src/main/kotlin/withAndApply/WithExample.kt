package withAndApply

class WithExample {

    fun alphabet(): String {
        val result = StringBuilder()
        for (letter in 'A'..'Z') {
            result.append(letter)
        }
        return result.toString()
    }

    fun alphabetWith(): String {
        val result = StringBuilder()
        return with(result) {
            for (letter in 'A'..'Z') {
                result.append(letter)
            }
            this.toString()
        }
    }

    fun alphabetWithRefactor() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        this.toString()
    }

}

fun main() {

    val withTest = WithExample()

    withTest.alphabet().toList().let { System.err.println(it) }
    withTest.alphabetWith().toList().let { System.err.println(it) }
    withTest.alphabetWithRefactor().toList().let { System.err.println(it) }


}