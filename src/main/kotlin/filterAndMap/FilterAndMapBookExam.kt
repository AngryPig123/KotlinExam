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
    System.err.println(books.flatMap { it.authors }.toSet())



}
