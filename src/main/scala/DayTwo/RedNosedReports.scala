package DayTwo

/*
  - Level Array inside Report Array; Report is a collection of levels.
  - 1. All levels in a report must be either increasing or decreasing:
      Map over levels pairwise and check if all are increasing or decreasing OR
      method for sorting and comparing with og list.
  - 2. Adjacent levels must differ by at least 1 and at most 3:
      if increasing, map over levels pairwise and check if all are increasing by 1, 2, or 3
      if decreasing, map over levels pairwise and check if all are decreasing by 1, 2, or 3
      OR distance between pairs is 1, 2, or 3
  - Count reports that are safe
 */

case class ReportSorting(increasing: Boolean, decreasing: Boolean)

class RedNosedReports {
  def areAllLevelsIncreasingOrDecreasing(levels: Seq[Int]): ReportSorting = {
    val sortedIncreasing = levels.sorted
    val sortedDecreasing = levels.sorted.reverse

    val increasing = (levels == sortedIncreasing)
    val decreasing = levels == sortedDecreasing

    ReportSorting(increasing, decreasing)
  }

  def areTwoLevelsWithinSafeRange(level1: Int, level2: Int): Boolean = {
    val diff = Math.abs(level1 - level2)
    diff >= 1 && diff <= 3
  }

  def areAllLevelsWithinSafeRange(reportLevels: Seq[Int]): Boolean = {
    val slidingWindow = reportLevels.sliding(2, 1) // Slidibg in pairs, over each one
    slidingWindow.forall {
      case Seq(level1, level2) =>
        areTwoLevelsWithinSafeRange(level1, level2)
    }
  }

  def detectSafeReport(levels: Seq[Int]): Boolean = {
    val reportSorting = areAllLevelsIncreasingOrDecreasing(levels)
    val levelsWithinSafeRange = areAllLevelsWithinSafeRange(levels)
    (reportSorting.increasing || reportSorting.decreasing) && levelsWithinSafeRange
  }

  def countSafeReports(reports: Seq[Seq[Int]]): Int = {
    reports.count { report =>
      detectSafeReport(report)
    }
  }

  def dampenReport(report: Seq[Int], atIndex: Int): Seq[Int] = {
    report.take(atIndex) ++ report.drop(atIndex + 1) // Takes first n elements and appends rest of elements after n + 1
  }

  def possibleReportsWithDampeners(report: Seq[Int]): Seq[Seq[Int]] = {
    report.indices.map { index =>
      dampenReport(report, index)
    }
  }

  // For each report, get dampened reports, and see if any are safe. if safe, count as 1
  def countSafeReportsAfterDampening(reports: Seq[Seq[Int]]): Int = {
    reports.map { report => 
      val dampenedReports = possibleReportsWithDampeners(report)
        dampenedReports.map { report =>
          detectSafeReport(report)
        }
        dampenedReports.exists(detectSafeReport)
    }.count(_ == true)
  }

}
