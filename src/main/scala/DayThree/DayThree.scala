package DayThree

import utils.InputDAO

object DayThree extends App {
  val inputDAO = new InputDAO

  val input = inputDAO.readFileAsString("src/main/scala/DayThree/DayThreeInput.txt")
  val mullItOver = new MullItOver
  val multiplyInstructions = mullItOver.extractInstructions(input)

  // Part One
  val result = mullItOver.countAllMultiples(multiplyInstructions)
  println(s"The product of all mul instructions is: $result")

  // Part Two
  val resultWithConditionals = mullItOver.multiplyWithConditionals(input)
  println(s"The product of all mul instructions that aren't disabled is: $resultWithConditionals")
}
