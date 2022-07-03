package kotlinTypeExample.nullPakage

class NullAbility {
    /**
     * if -> elvis 표현식을 이용한 null 체크.
     */
    fun strLen(s: String?): Int = s?.length ?: 0
    fun strLen2(s: String?) = s?.length
}

fun main() {

//    String? = String or null
    val nullTest = NullAbility()
//    nullTest.strLen(null)   //  컴파일 오류  null 을 못넘기게 막는다.
    nullTest.strLen2(null)   // ?. 호출로 null 을 받을 수 있게 한다.
}