package edu.learn.scala.test_styles

import org.scalatest.{Matchers, WordSpec}

/**
  * Enforces discipline on a specification tet
  */
class WordSpecTest extends WordSpec with Matchers {

  "A Set" when {
    "empty" should {
      "have size 0" in {
        assert(Set.empty.size == 0)
      }

      "produce NoSuchElementException when head is invoked" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
}

