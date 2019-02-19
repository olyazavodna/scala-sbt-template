package edu.learn.scala.test_styles

import org.scalatest.FunSuite

/**
  * For teams coming from xUnit
  */
class FunSuiteTest extends FunSuite {

  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}
