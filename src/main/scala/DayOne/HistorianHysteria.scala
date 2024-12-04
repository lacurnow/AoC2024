package DayOne

/*
- How to pair up? Smallest vs smallest. Sort both lists low to high.
- split each line into int1 and int2.
- Zip up pairs. Calculate distance between pairs.
- Sum up total distances.
 */

class HistorianHysteria {

  def generateListUsingValueAtIndex(n: Int, lines: Seq[String]): Seq[Int] = {
    lines.map { line =>
      val splits = line.split(" ").filter(_.nonEmpty)
      splits(n).toInt
    }
  }

  def getTotalDistanceBetweenSmallestPairs(list1: Seq[Int], list2: Seq[Int]): Int = {
    implicit val ordering: Ordering[Int] = Ordering.Int

    val sortedList1 = list1.sorted
    val sortedList2 = list2.sorted
    val zippedPairs = sortedList1.zip(sortedList2)
    zippedPairs.map { case (int1, int2) =>
      Math.abs(int1 - int2)
    }.sum
  }

  def generateValueFrequencyMap(list: Seq[Int]): Map[Int, Int] = {
    list.map { int =>
      int -> list.count(_ == int)
    }.toMap
  }

  def frequencyMultiplier(int: Int, map: Map[Int, Int]): Int = {
    val multiplierInt = map.getOrElse(int, 0)
    int * multiplierInt
  }

  def getSimilarityScore(leftList: Seq[Int], rightList: Seq[Int]): Int = {
    val frequencyDict = generateValueFrequencyMap(rightList)
    leftList.map { int =>
      frequencyMultiplier(int, frequencyDict)
    }.sum
  }

}
