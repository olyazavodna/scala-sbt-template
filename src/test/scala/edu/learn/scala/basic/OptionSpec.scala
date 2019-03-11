package edu.learn.scala.basic

import org.scalatest.{FlatSpec, Ignore, Matchers}

/**
  * [[https://danielwestheide.com/blog/2012/12/19/the-neophytes-guide-to-scala-part-5-the-option-type.html]]
  */
@Ignore
class OptionSpec extends FlatSpec with Matchers {

  "Option" should "result in None when created with null" in {
    val option = Option(null)

    option shouldBe None
  }

  it should "result in Some value when created with an actual object" in {
    val option = Option("test")

    option shouldBe Some("test")
  }

  ignore should "execute foreach method if contains the value" in {
    ???
  }

  ignore should "return a value on getOrElse if not empty" in {
    ???
  }

  ignore should "return a fallback value on getOrElse if empty" in {
    ???
  }
}
