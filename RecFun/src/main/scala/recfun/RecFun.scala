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
  def pascal(c: Int, r: Int): Int =
    if (r == c || c == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    if (chars.isEmpty) throw new IllegalArgumentException("The string is empty!")
    else {
      @scala.annotation.tailrec
      def count(chars: List[Char], opening: Int): Boolean = {
        if (chars.isEmpty) opening == 0
        else{
          val head = chars.head
          if (head == '(') count(chars.tail, opening + 1)
          else if (head == ')') opening > 0 && count(chars.tail, opening - 1)
          else count(chars.tail, opening)
        }
      }
      count(chars, 0)
    }
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0 || coins.isEmpty) 0
    else{
      val head = coins.head
      val tail = coins.tail
      if (head == money) 1 + countChange(money, tail)
      else if (head < money) countChange(money - head, coins) + countChange(money, tail)
      else countChange(money, tail)
    }
  }
}
