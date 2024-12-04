package DayThree

class MullItOver {
  def extractInstructions(str: String): Seq[(Int, Int)] = {
    val mulRegexPattern = "mul\\((\\d+),(\\d+)\\)".r
    
    val mulInstructions = mulRegexPattern.findAllMatchIn(str).toSeq
    mulInstructions.map { instruction =>
      (instruction.group(1).toInt, instruction.group(2).toInt)
    }
  }

  def multiplyInstruction(instruction: (Int, Int)): Int = {
    instruction._1 * instruction._2
  }

  def countAllMultiples(muls: Seq[(Int, Int)]): Int = {
    muls.map(multiplyInstruction).sum
  }

  def splitAtConditionals(str: String): Seq[String] = {
    val doRegexPattern = "do\\(\\)".r
    str.split("do")
  }

  def multiplyWithConditionals(allInstructions: String): Int = {
    splitAtConditionals(allInstructions).map { subInstructions =>
      if (subInstructions.startsWith("n't()")) {
        0
      } else {
        countAllMultiples(extractInstructions(subInstructions))
      }
    }.sum
  }
}
