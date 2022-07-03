package filterAndMap.testPakage

import filterAndMap.dataClass.Person

class TestClass {

}

fun main() {

    val createPerson = ::Person //  ::  생성자 참조.
    val personList = mutableListOf<Person>()
    for (i in 1..5) {
        personList += createPerson("test$i", i * 10)
    }

//     String ArrayList 로 만들기?
    personList.joinToString { it ->
        it.age.toString()
        it.name
    }.let { System.err.println(it.split(",").javaClass) }

    fun Person.isAdult() = age >= 21
    val predicate = Person::isAdult
    System.err.println(predicate(Person("test", 20)))   //  false
    System.err.println(predicate(Person("test", 22)))   //  true

}