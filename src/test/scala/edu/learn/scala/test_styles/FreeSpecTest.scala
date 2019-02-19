package edu.learn.scala.test_styles

import org.scalatest.FreeSpec

class FreeSpecTest extends FreeSpec {

  "A Set" - {
    "when empty" - {
      "both tests" - {
        "should have size 0" in {
          assert(Set.empty.size == 0)
        }

        "should produce NoSuchElementException when head is invoked" in {
          assertThrows[NoSuchElementException] {
            Set.empty.head
          }
        }
      }
    }
  }
}
