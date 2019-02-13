package edu.learn.scala.basic

import org.scalatest.{FlatSpec, Matchers}

object ListSpec {

  val someList = List(1, 2, 3, 4, 5)
}

class ListSpec extends FlatSpec with Matchers {
  import ListSpec._

  "List" should "produce transformed list when map method called" in {
    val someTransformation: Int => Int =
      value => value * 2

    val expectedList = List(2, 4, 6, 8, 10)
    val someTransformedList = someList.map(someTransformation)

    someTransformedList shouldBe expectedList
  }

  it should "produce transformed flat list when flatMap method called" in {
    ???
  }

  it should "produce filtered list when filter method called" in {
    ???
  }

  it should "an end value when reduce method called" in {
    ???
  }

  // will it always result with two groups ?
  it should "split list into two groups when partition method called" in {
    ???
  }

  // what type resulted object have ? how can you test its value ?
  it should "return value when find method called with proper predicate" in {
    ???
  }

  // will resulted set.count be equal initial list.count ?
  it should "produce a Set when toSet method" in {
    ???
  }

  it should "produce a diff list between lists when diff method called" in {
    ???
  }

  it should "produce an intersection list between lists when diff method called" in {
    ???
  }
}
