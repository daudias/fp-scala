package week2

import scala.annotation.tailrec

object Rationals extends App {
    val x = new Rational(1, 2)
    //println(x.numer, x.denom)

    val y = new Rational(1, 3)
    //println(x.add(y))

    def exercise1(): Unit = {
        // 1. Add method neg to Rational class
        // x.neg -> -x
        // 2. Add a method sub
        // 3. Compute x - y - z
        val x = new Rational(1, 3)
        val y = new Rational(5, 7)
        val z = new Rational(3, 2)
        println(x.sub(y).sub(z))
    }
    //exercise1()

    // 2 lecture
    //println(x.less(y))

}

class Rational(x: Int, y: Int) {
    @tailrec
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private val g = gcd(x, y)

    def numer: Int = x / g
    def denom: Int = y / g

    def less(that: Rational): Boolean = numer * that.denom < that.numer * denom

    // On the inside of a class, the name this represents the object on which the current method is executed.
    def max(that: Rational): Rational = if (this.less(that)) that else this

    def neg =
        new Rational(-numer, denom)

    def sub(that: Rational): Rational = add(that.neg)

    def add(that: Rational) =
        new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

    override def toString = numer + "/" + denom
}
