package lamda

class LambdaExam {

    fun people1(): Person { //maxBy
        val people = listOf(Person("Alice", 29), Person("Bob", 31))
        people.maxBy { p: Person -> p.age }
        people.maxBy { p: Person -> p.age }
        return people.maxBy {
            it.age
            it.name
        }
    }

    fun people2(): String { //  field joinToString
        val people = listOf(Person("이몽룡", 29), Person("성춘향", 25))
        return people.joinToString(" ") { p: Person -> p.name }
//        return people.joinToString(" ") { it.name }
    }

    fun people3(): String { //  field joinToString
        val people = listOf(Person("이몽룡", 29), Person("성춘향", 25))
        return people.joinToString {
            "${it.name} ${it.age}"
        }
    }

    fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
//        타입을 명시 하는 편이 좋나.
        messages.forEach {
            System.err.println("$prefix : $it")
        }
    }

    fun printProblemCounts(response: Collection<String>) {
        var clientErrors = 0
        var serverErrors = 0
        response.forEach {
            if (it.startsWith("4")) {
                clientErrors++
            } else if (it.startsWith("5")) {
                serverErrors++
            }
        }
        System.err.println("ClientError count = $clientErrors :: ServerError count = $serverErrors")
    }

}

fun main() {

    val lambdaTest = LambdaExam()
    System.err.println(lambdaTest.people1())
    System.err.println(lambdaTest.people2())
    System.err.println(lambdaTest.people3())

    val message = listOf("404", "403", "402")
    lambdaTest.printMessagesWithPrefix(message, "error")

    val responseError = listOf("404 error", "418 error", "200 ok ", "500 error")
    lambdaTest.printProblemCounts(responseError)

    val createPerson = ::Person
    System.err.println(createPerson("test", 21))

}