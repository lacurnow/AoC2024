package DayOne

import org.scalatest.flatspec.AnyFlatSpec

class HistorianHysteriaSpec extends AnyFlatSpec {

  behavior of "generateListUsingValueAtIndex"

  it should "return a list of integers from a list of strings at a given index" in {
    val historianHysteria = HistorianHysteria()
    val lines = List("1 2 3 ", "4 5 6 ", "7 8 9 ")
    val list1 = historianHysteria.generateListUsingValueAtIndex(0, lines)
    val list2 = historianHysteria.generateListUsingValueAtIndex(1, lines)
    val list3 = historianHysteria.generateListUsingValueAtIndex(2, lines)
    assert(list1 == List(1, 4, 7))
    assert(list2 == List(2, 5, 8))
    assert(list3 == List(3, 6, 9))
  }

  behavior of "getTotalDistanceBetweenSmallestPairs"

  it should "return the total distance between the smallest pairs of two lists" in {
    val historianHysteria = HistorianHysteria()
    val list1 = List(1, 4, 10)
    val list2 = List(2, 5, 7)
    val totalDistance = historianHysteria.getTotalDistanceBetweenSmallestPairs(list1, list2)
    assert(totalDistance == 5)
  }

  behavior of "generateValueFrequencyMap"

  it should "return a map of the frequency of each value in a list" in {
    val historianHysteria = HistorianHysteria()
    val list = List(1, 2, 2, 3, 3, 3)
    val valueFrequencyMap = historianHysteria.generateValueFrequencyMap(list)
    assert(valueFrequencyMap == Map(1 -> 1, 2 -> 2, 3 -> 3))
  }

  behavior of "frequencyMultiplier"

  it should "return the product of the value and its frequency" in {
    val historianHysteria = HistorianHysteria()
    val map = Map(1 -> 2, 2 -> 3, 3 -> 4)
    val product1 = historianHysteria.frequencyMultiplier(1, map)
    val product2 = historianHysteria.frequencyMultiplier(2, map)
    val product3 = historianHysteria.frequencyMultiplier(3, map)
    assert(product1 == 2)
    assert(product2 == 6)
    assert(product3 == 12)
  }

  behavior of "getSimilarityScore"

  it should "return the similarity score between two lists" in {
    val historianHysteria = HistorianHysteria()
    val leftList = List(1, 2, 2, 3, 3, 3)
    val rightList = List(1, 1, 2, 2, 2, 3)
    val similarityScore = historianHysteria.getSimilarityScore(leftList, rightList)
    assert(similarityScore == 23)
  }
}
