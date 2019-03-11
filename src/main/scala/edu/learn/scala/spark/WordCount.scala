package edu.learn.scala.spark

import org.apache.spark.sql.functions.sum
import org.apache.spark.sql.{Dataset, SaveMode, SparkSession}

object WordCount {

  def main(args: Array[String]): Unit = {
    Config.parser.parse(args, Config()) match {
      case None => System.exit(1)
      case Some(config) =>
        run(config) {
          SparkSession.builder()
            .master("local[*]")
            .getOrCreate()
        }
    }
  }

  def run(config: Config)
         (implicit spark: SparkSession) {

    import spark.implicits._

    val input = spark.read
      .text(config.inputLocation)
      .as[String]

    val words: Dataset[String] = splitText(input)
      .map(_.toLowerCase)

    val counts: Dataset[WordCount] = calculateCount(words)

    counts.explain(extended = true)

    counts.write.mode(SaveMode.Overwrite)
      .csv(config.outputLocation)
  }

  def splitText(lines: Dataset[String], separator: String = " ")
               (implicit spark: SparkSession): Dataset[String] = {
    import spark.implicits._

    lines.flatMap(_.split(separator))
  }

  def calculateCount(words: Dataset[String])
                    (implicit spark: SparkSession): Dataset[WordCount] = {
    import spark.implicits._

    words
      .map[(String, Int)] { word: String => (word, 1) }
      .groupBy($"_1" as 'word)
      .agg(sum($"_2") as 'count)
      .orderBy('count.desc)
      .as[WordCount]
  }

}

case class WordCount(word: String, count: Int)
