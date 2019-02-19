import scala.concurrent.Future

import scala.concurrent.ExecutionContext.global

println("first")

Future {
  Thread.sleep(1000)
  println("second")
}(global)

println("third")

