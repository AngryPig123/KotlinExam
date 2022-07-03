package filterAndMap

import filterAndMap.dataClass.Book

class FilterAndMapPersonExam {

}

fun main() {

    val createBook = ::Book
    val books = mutableListOf<Book>()
    for (i in 1..5) {
        books += createBook(listOf("김창렬$i and 노형욱$i"), "책이름${i}a")
        books += createBook(listOf("김창렬$i"), "책이름${i}b")
        books += createBook(listOf("노형욱$i"), "책이름${i}c")
    }

    /** flatMap
     * @Info :  ex) 책의 모든 저자를 모두 가져오고 싶을떄 (공동 저자.)
     * books.flatMap { it.authors }.toSet() = 해당 메소드는 책의 저자(공동 저자는 따로 취급)를 알고 싶을때
     */
//    System.err.println(books.flatMap { it.authors }.toSet())

    /**
     *  flatMapExam :   인자로 받은 람다를 컬렉션의 모든 객체에 적용시킨다.
     *  "abc" => [a][b][c]
     *  "cde" => [c][d][e]
     *  flatMapExam.flatMap => [a][b][c][c][d][e]
     */

    val flatMapExam = listOf("123", "345")
    flatMapExam.flatMap { it.toList() }
        .let {
//            it.forEach { it -> System.err.println(it.toString().toInt()) }  //  flatMap 에 담기는걸 보니 Char 로 담긴다.
        }

    /**
     *  asSequence() : 임시컬렉션에 담지 않고 종료 부에서 결과를 출력해준다?. 지연 계산 연산!
     */
    flatMapExam.asSequence().flatMap { it.toList() }
        .let {
//            it.forEach { it -> System.err.println(it.toString().toInt()) }  //  flatMap 에 담기는걸 보니 Char 로 담긴다.
        }

    /**
     * asSequence Test : 해당 코드는 실행되지 않음 ... 최종 연산이 없기 때문.
     */
    listOf(1, 2, 3, 4).asSequence()
        .map { println("map($it)"); it * it }
        .filter { print("filter($it)");it % 2 == 0 }

    /**
     * 최종 연산이 포함된 테스트
     */
    listOf(1, 2, 3, 4).asSequence()
        .map { println("map($it)"); it * it }   //  ??
        .filter { print("filter($it)");it % 2 == 0 }    //  ??
//        .toList()

    /**
     * Generate sequence
     */
    val naturalNumbers = generateSequence(0) { it + 1 }
    naturalNumbers.takeWhile { it <= 100 }.sum()


}
