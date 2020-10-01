package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || c > r || r < 0)  0
    else if (c == 0 && r == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def help(chars: List[Char], open: Int): Boolean = {
      if (open < 0) false
      else if (chars.isEmpty) open == 0
      else {
        if (chars.head == '(') help(chars.tail, open + 1)
        else if (chars.head == ')') help(chars.tail, open - 1)
        else help(chars.tail, open)
      }
    }
    print(help(chars, 0))
    help(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.nonEmpty) countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else 0
  }
}
