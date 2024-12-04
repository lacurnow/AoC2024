package DayThree

import org.scalatest.flatspec.AnyFlatSpec

class MullItOverSpec extends AnyFlatSpec {
  
  behavior of "extractInstruction"
  
  it should "return a list of tuples for each mul instruction" in {
    val mullItOver = new MullItOver
    val str = "mul(73,623)when()mul(793,458)'~where()how()?how(569,237)/[mul(709,198)"
    val expected = Seq((73, 623), (793, 458), (709, 198))
    assert(mullItOver.extractInstructions(str) == expected)
  }
  
  behavior of "multiplyInstruction"
  
  it should "return the product of the two numbers in the tuple" in {
    val mullItOver = new MullItOver
    val instruction = (73, 623)
    val expected = 45479
    assert(mullItOver.multiplyInstruction(instruction) == expected)
  }
  
  behavior of "countAllMultiples"
  
  it should "sum up the products of all the tuples" in {
    val mullItOver = new MullItOver
    val muls = Seq((73, 623), (793, 458), (709, 198))
    val expected = 45479 + 363194 + 140382
    assert(mullItOver.countAllMultiples(muls) == expected)
  }
  
  behavior of "splitAtConditionals"
  
  it should "split the string at the 'do'- conditionals" in {
    val mullItOver = new MullItOver
    val str = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
    val expected = Seq("xmul(2,4)&mul[3,7]!^", "n't()_mul(5,5)+mul(32,64](mul(11,8)un", "()?mul(8,5))")
    assert(mullItOver.splitAtConditionals(str) == expected)
  }
  
  behavior of "multiplyWithConditionals"
  
  it should "return the product of all instructions that aren't diasbled" in {
    val mullItOver = new MullItOver
    val allInstructions = "xmul(2,4)&mul[3,7]!^do()_mul(5,5)+mul(32,64](mul(11,8)undon't()?mul(8,5))"
    val expected = 2*4 + 5*5 + 11*8 
    assert(mullItOver.multiplyWithConditionals(allInstructions) == expected)
  }

}
