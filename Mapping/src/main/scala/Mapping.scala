object Mapping{
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(arr: Array[Int], i: Int): Int = {
    if (i >= arr.length) zero
    else combine(f(arr(i)), mapReduce(f, combine, zero)(arr, i + 1))
  }

  def arraySum(elems: Array[Int]): Int = mapReduce(x => x, (x, y) => x + y, 0)(elems, 0)

  def arraySqrSum(elems: Array[Int]): Int = mapReduce(x => x * x, (x, y) => x + y, 0)(elems, 0)

  def arrayProd(elems: Array[Int]): Int = mapReduce(x => x, (x, y) => x * y, 1)(elems, 0)

  def multiMapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(arr: Array[Array[Int]], i: Int): Int = {
    if (i >= arr(0).length) zero
    else combine(mapReduce(f, combine, zero)(arr(i), 0), multiMapReduce(f, combine, zero)(arr, i + 1))
  }

  def multiArraySum(elems: Array[Array[Int]]): Int = multiMapReduce(x => x, (x, y) => x + y, 0)(elems, 0)

  def multiArraySqrSum(elems: Array[Array[Int]]): Int = multiMapReduce(x => x * x, (x, y) => x + y, 0)(elems, 0)

  def multiArrayProd(elems: Array[Array[Int]]): Int = multiMapReduce(x => x, (x, y) => x * y, 1)(elems, 0)
}