import org.junit._
import org.junit.Assert.assertEquals

class MappingTest {
  import Mapping._

  // 1D tests

  val arr: Array[Int] = (5 to 10).toArray

  @Test def arraySumTest(): Unit =
    assertEquals(45, arraySum(arr))

  @Test def arraySqrSumTest(): Unit =
    assertEquals(355, arraySqrSum(arr))

  @Test def arrayProdTest(): Unit =
    assertEquals(151200, arrayProd(arr))

  // 2D tests

  val multiArr: Array[Array[Int]] = Array.ofDim[Int](4, 4)
  for (i <- 0 to 3; j <- 0 to 3)
    multiArr(i)(j) = 2

  @Test def multiArraySumTest(): Unit =
    assertEquals(32, multiArraySum(multiArr))

  @Test def multiArraySumSqrTest(): Unit =
    assertEquals(64, multiArraySqrSum(multiArr))

  @Test def multiArrayProdTest(): Unit =
    assertEquals(65536, multiArrayProd(multiArr))

}
