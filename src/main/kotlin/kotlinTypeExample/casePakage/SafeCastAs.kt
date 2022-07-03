package kotlinTypeExample.casePakage

class SafeCastAs {

}

class Person(val firstName: String, val lastName: String) {

    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }


}

fun main() {

    val testInt: Int = 5
    System.err.println(testInt)
    (testInt as? Double).let { System.err.println(it?.javaClass) }

}