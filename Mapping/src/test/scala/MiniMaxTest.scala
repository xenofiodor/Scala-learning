import org.junit.Assert.assertEquals
import org.junit.Test

class MiniMaxTest {
  import MiniMax._

  // 1D tests

  val arr: Array[Int] = (5 to 10).toArray

  @Test def maxTest(): Unit =
    assertEquals(10, max(arr))

  @Test def minTest(): Unit =
    assertEquals(5, min(arr))

  @Test def maxSumOfTwoTest(): Unit =
    assertEquals(19, maxSumOfTwo(arr))

  @Test def minSumOfTwoTest(): Unit =
    assertEquals(11, minSumOfTwo(arr))


  // 2D tests

  val multiArr: Array[Array[Int]] = Array.ofDim[Int](4, 4)
  for (i <- 0 to 3; j <- 0 to 3)
    multiArr(i)(j) = 2
  multiArr(0)(0) = -3
  multiArr(1)(1) = 5

  @Test def maxMultiTest(): Unit =
    assertEquals(5, maxMulti(multiArr))

  @Test def minMultiTest(): Unit =
    assertEquals(-3, minMulti(multiArr))

  @Test def maxSumOfTwoMultiTest(): Unit =
    assertEquals(7, maxSumOfTwoMulti(multiArr))

  @Test def minSumOfTwoMultiTest(): Unit =
    assertEquals(-1, minSumOfTwoMulti(multiArr))

}
