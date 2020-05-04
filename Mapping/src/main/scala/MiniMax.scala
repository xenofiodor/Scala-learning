object MiniMax {

  // 1D array

  def minimaxN(elems: Array[Int], f: (Int, Int) => Int, n: Int): Int = {
    val size = elems.size
    val stop = size - (n - 1)
    @scala.annotation.tailrec
    def goFrom(i: Int, pivot: Int): Int = {
      if (i < stop) goFrom(i + 1, f(sumOfN(elems, n, i), pivot))
      else pivot
    }
    goFrom(0, sumOfN(elems, n, 0))
  }

  def sumOfN(elems: Array[Int], n: Int, i: Int): Int = {
    val stop = i + n
    @scala.annotation.tailrec
    def sumFrom(j: Int, sum: Int): Int = {
      if (j < stop) sumFrom(j + 1, sum + elems(j))
      else sum
    }
    sumFrom(i, 0)
  }

  def max(elems: Array[Int]): Int = minimaxN(elems, math.max, 1)
  def min(elems: Array[Int]): Int = minimaxN(elems, math.min, 1)

  def maxSumOfTwo(elems: Array[Int]): Int = minimaxN(elems, math.max, 2)
  def minSumOfTwo(elems: Array[Int]): Int = minimaxN(elems, math.min, 2)

  // 2D array

  def minimaxMultiN(elems: Array[Array[Int]], f: (Int, Int) => Int, n: Int): Int = {
    val size = elems(0).size
    @scala.annotation.tailrec
    def goFrom(i: Int, pivot: Int): Int = {
      if (i < size) goFrom(i + 1, f(minimaxN(elems(i), f, n), pivot))
      else pivot
    }
    goFrom(0, minimaxN(elems(0), f, n))
  }

  def maxMulti(elems: Array[Array[Int]]): Int = minimaxMultiN(elems, math.max, 1)
  def minMulti(elems: Array[Array[Int]]): Int = minimaxMultiN(elems, math.min, 1)

  def maxSumOfTwoMulti(elems: Array[Array[Int]]): Int = minimaxMultiN(elems, math.max, 2)
  def minSumOfTwoMulti(elems: Array[Array[Int]]): Int = minimaxMultiN(elems, math.min, 2)
}
