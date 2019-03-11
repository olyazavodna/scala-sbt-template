package edu.learn.scala.spark

import scopt.OptionParser

object Config {

  val parser: OptionParser[Config] = new OptionParser[Config]("WordCount") {

    opt[String]("input") action { (input, config) =>
      config.copy(inputLocation = input)
    }

    opt[String]("output") action { (output, config) =>
      config.copy(outputLocation = output)
    }
  }
}

case class Config(inputLocation: String = "",
                  outputLocation: String = "")
