package DayTwo

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.immutable.List

class RedNosedReportsSpec extends AnyFlatSpec {

  private val redNosedReports = RedNosedReports()

  behavior of "areAllLevelsIncreasingOrDecreasing"

  it should "return true if all levels are increasing" in {
    val levels = List(1, 2, 3, 4, 5)
    val result = redNosedReports.areAllLevelsIncreasingOrDecreasing(levels)
    assert(result.increasing)
    assert(!result.decreasing)
  }

  it should "return true if all levels are decreasing" in {
    val levels = List(5, 4, 3, 2, 1)
    val result = redNosedReports.areAllLevelsIncreasingOrDecreasing(levels)
    assert(!result.increasing)
    assert(result.decreasing)
  }

  it should "return false if levels are not increasing or decreasing" in {
    val levels = List(1, 2, 3, 2, 1)
    val result = redNosedReports.areAllLevelsIncreasingOrDecreasing(levels)
    assert(!result.increasing)
    assert(!result.decreasing)
  }

  behavior of "areTwoLevelsWithinSafeRange"

  it should "return true if two levels are within a safe range" in {
    val level1 = 5
    val level2 = 2
    val result = redNosedReports.areTwoLevelsWithinSafeRange(level1, level2)
    assert(result)
  }

  it should "return false if two levels are not within a safe range" in {
    val level1 = 5
    val level2 = 1
    val result = redNosedReports.areTwoLevelsWithinSafeRange(level1, level2)
    assert(!result)
  }

  behavior of "areAllLevelsWithinSafeRange"

  it should "return true if all levels are within a safe range" in {
    val ascendingLevels = List(1, 3, 6, 7, 9)
    val descendingLevels = List(10, 8, 6, 4, 1)
    val result1 = redNosedReports.areAllLevelsWithinSafeRange(ascendingLevels)
    val result2 = redNosedReports.areAllLevelsWithinSafeRange(descendingLevels)
    assert(result1)
    assert(result2)
  }

  it should "return false if all levels are not within a safe range" in {
    val ascendingLevels = List(1, 3, 6, 7, 15)
    val descendingLevels = List(15, 8, 6, 4, 1)
    val duplicateLevels = List(1, 3, 6, 6, 10)
    val result = redNosedReports.areAllLevelsWithinSafeRange(ascendingLevels)
    val result2 = redNosedReports.areAllLevelsWithinSafeRange(descendingLevels)
    val result3 = redNosedReports.areAllLevelsWithinSafeRange(duplicateLevels)
    assert(!result)
    assert(!result2)
    assert(!result3)
  }

  behavior of "detectSafeReports"

  it should "return true if report is safe" in {
    val levels = List(1, 3, 6, 7, 9)
    val result = redNosedReports.detectSafeReport(levels)
    assert(result)
  }

  it should "return false if report is unsafe" in {
    val levels = List(1, 3, 6, 7, 15)
    val result = redNosedReports.detectSafeReport(levels)
    assert(!result)
  }

  behavior of "countSafeReports"

  it should "count the number of reports in a collection of reports that are safe" in {
    val reports = List(
      List(7, 6, 4, 2, 1), //Safe
      List(1, 2, 7, 8, 9), //Unsafe
      List(9, 7, 6, 2, 1), //Unsafe
      List(1, 3, 2, 4, 5), //Unsafe
      List(8, 6, 4, 4, 1), //Unsafe
      List(1, 3, 6, 7, 9) //Safe
    )
    val result = redNosedReports.countSafeReports(reports)
    assert(result == 2)
  }

  behavior of "dampenReport"

  it should "produce a new report with one of the elements removed / 'dampened' at index" in {
    val report = List(1, 2, 3, 4, 5)
    val report2 = List(1, 2, 3, 4, 5, 6)
    val result = redNosedReports.dampenReport(report, 2)
    val result2 = redNosedReports.dampenReport(report2, 3)
    assert(result == List(1, 2, 4, 5))
    assert(result2 == List(1, 2, 3, 5, 6))
  }

  behavior of "possibleReportsWithDampeners"

  it should "produce a list of reports with one of the elements removed / 'dampened' at each index" in {
    val report = List(1, 2, 3, 4, 5)
    val result = redNosedReports.possibleReportsWithDampeners(report)
    assert(result == List(
      List(2, 3, 4, 5),
      List(1, 3, 4, 5),
      List(1, 2, 4, 5),
      List(1, 2, 3, 5),
      List(1, 2, 3, 4)
    ))
  }

  behavior of "countSafeReportsAfterDampening"

  it should "count the number of reports in a collection of reports that are safe with a dampener" in {
    val reports = List(
      List(7, 6, 4, 2, 1), //Safe
      List(1, 2, 7, 8, 9), //Unsafe
      List(9, 7, 6, 2, 1), //Unsafe
      List(1, 3, 2, 4, 5), //Safe
      List(8, 6, 4, 4, 1), //Safe
      List(1, 3, 6, 7, 9), //Safe
      List(82, 85, 86, 83, 85, 87, 89) // Unsafe
    )
    val result = redNosedReports.countSafeReportsAfterDampening(reports)
    assert(result == 4)
  }
}
