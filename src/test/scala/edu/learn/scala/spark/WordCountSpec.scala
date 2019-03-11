package edu.learn.scala.spark

import org.scalatest.{FlatSpec, Matchers}

object WordCountSpec {

  val someWord: String = "some"
  val someOtherWord: String = "other"
  val oneMoreWord: String = "more"

  val separator = " "

  val someWords: Seq[String] = Seq(someWord, someOtherWord)
  val someOtherWords: Seq[String] = Seq(oneMoreWord, someWord)

}

class WordCountSpec extends FlatSpec with Matchers with SparkBaseSpec {
  import WordCountSpec._

  behavior of "WordCount"

  it should "split provided text to words based on a separator" in {

    import spark.implicits._

    val someTextLine: String = someWords mkString separator
    val someOtherTextLine: String = someOtherWords mkString separator

    val textDs = Seq(someTextLine, someOtherTextLine).toDS

    val splittedWords = WordCount.splitText(textDs)

    splittedWords.collect().toSet shouldBe (someWords ++ someOtherWords).toSet
  }

  ignore should "calculate words count in provided text" in {

    ???
  }
}
