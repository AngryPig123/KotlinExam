package filterAndMap

import filterAndMap.dataClass.Person

class FilterAndMapExam {

}

fun main() {

//    val list = listOf(1, 2, 3, 4, 5)
//    list.filter { it >= 3 }.forEach { System.err.println(it) }  //  filter 로 거르고 forEach 로 뽑는다

    val createPerson = ::Person
    val personList = mutableListOf<Person>()
    for (i in 1..5) {
        personList += createPerson("김창렬$i", i * 10)
        personList += createPerson("노형욱$i", i * 10)
    }

    /**
    personList.joinToString(",") { it.name }.let { System.err.println(it.split(",").size) }
    System.err.println(personList.map { it.name })  //  list 로 저장된 it.name 값을 가져온다.
    personList.map { System.err.println(it.name) }  //  list 를 map 으로 이터레이터 하여 가져온다.
     */

//  나이가 가장 많은 사람을 구하는 표현식.
//    val maxAgePerson = personList.maxBy { it.age }.let { it.age }

    /**
     * @info :
     * val maxAgePerson = personList.maxBy { it.age }!!.age 이게 가능한 이유는
     * personList.maxBy { it.age }!! 자체가 Person 이기 때문에
     */
    val maxAgePerson = personList.maxBy { it.age }!!.age
    personList.filter { it.age == maxAgePerson }.let { System.err.println(it) }

    /**
     *  @info : [personList.all] ageCheck 의 조건을 personList 가 전부 만족하는지를 판별(Boolean)
     *  @info : [personList.any] ageCheck 의 조건을 personList 중 하나라도 만족하는지를 판별(Boolean)
     *  @info : [personList.count] ageCheck 의 조건을 만족하는 personList 의 count 를 출력(Int)
     *  @info : [personList.find] ageCheck 의 조건을 만족하는 personList 중 하나를 출력( T ).
     */
    val ageCheck = { p: Person -> p.age >= 27 }
    personList.all(ageCheck).let { System.err.println(it) }
    personList.any(ageCheck).let { System.err.println(it) }
    personList.count(ageCheck).let { System.err.println(it) }
    personList.find(ageCheck).let { System.err.println(it) }

    /**
     * groupBy
     */

    /**
     * @Info : personList.groupBy { it.age } = personList 에서 age 값이 같은 요소끼리 리스트로 묶어준다.
     * @Info : groupBy = LinkedHashMap, index 가 아닌 key, value
     */
    personList.groupBy { it.age }.let { it.forEach { (t, u) -> System.err.println("$t :: $u") } }

    /**
     * @Info :  groupBy(String::first)  =   첫 글자가 같은 요소들끼리 묶어줌.
     */
    val groupByFirst = listOf("ab", "bc", "cd", "de", "ef")
    System.err.println(groupByFirst.groupBy(String::first))


}