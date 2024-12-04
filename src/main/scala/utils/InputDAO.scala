package utils

import scala.io.Source

class InputDAO {

  def readFileAsString(file: String): String = {
    Source.fromFile(file).mkString
  }

  def readTextFileAsLines(file: String): Seq[String] = {
    Source.fromFile(file).getLines.toSeq
  }

  def displayLines(lines: Seq[String]): Unit = {
    lines.foreach {
      line => print(line + "\n")
    }
  }

}
