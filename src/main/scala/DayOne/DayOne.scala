package DayOne

import utils.InputDAO

object DayOne extends App {
  private val inputDAO = InputDAO()
  val historianHysteria = HistorianHysteria()

  val lines = inputDAO.readTextFileAsLines("src/main/scala/DayOne/input.txt")
  inputDAO.displayLines(lines.take(3))

  // Part One
  val leftList = historianHysteria.generateListUsingValueAtIndex(0, lines)
  val rightList = historianHysteria.generateListUsingValueAtIndex(1, lines)

  val totalDistance = historianHysteria.getTotalDistanceBetweenSmallestPairs(leftList, rightList)
  println(s"Total distance between smallest pairs: $totalDistance")

  // Part Two
  val frequencyDict = historianHysteria.generateValueFrequencyMap(rightList)

  val similarityScore = leftList.map { int =>
    val x = historianHysteria.frequencyMultiplier(int, frequencyDict)
    print(x + "\n")
    x
  }.sum

  print(s"Total Similarity Score: $similarityScore")
}
