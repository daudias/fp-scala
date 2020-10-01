package week2

import scala.annotation.tailrec

object Currying extends App {
    def product(f: Int => Int)(a: Int, b: Int): Int = {
        if (a > b) 1
        else f(a) * product(f)(a + 1, b)
    }
    def factorial(n: Int): Int = product(x => x)(1, n)

    @tailrec
    def general(f: Int => Int, g: (Int, Int) => Int, acc: Int)(a: Int, b: Int): Int = {
        if (a > b) acc
        else general(f, g, g(acc, a))(a + 1, b)
    }
    println(general(x => x, (x, y) => x * y, 1)(1, 5)) // product
    println(general(x => x, (x, y) => x + y, 0)(1, 5)) // sum
}
