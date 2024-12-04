package DayTwo

import utils.InputDAO

object DayTwo extends App {
  val inputDAO = InputDAO()
  val redNosedReports = RedNosedReports()
  val lines = inputDAO.readTextFileAsLines("src/main/scala/DayTwo/input.txt")

  inputDAO.displayLines(lines.take(3))

  val reports = lines.map { line =>
    line.split(" ").map(_.toInt).toSeq
  }

  val partOneSafeReports = redNosedReports.countSafeReports(reports)
  print("Part One Safe Reports: " + partOneSafeReports)

  val partTwoSafeReports = redNosedReports.countSafeReportsAfterDampening(reports)
  print("Part Two Safe Reports: " + partTwoSafeReports)

}
