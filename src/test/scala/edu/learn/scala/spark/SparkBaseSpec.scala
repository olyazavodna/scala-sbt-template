package edu.learn.scala.spark

import org.apache.spark.sql.SparkSession

trait SparkBaseSpec {

  implicit lazy val spark: SparkSession = SparkSession.getActiveSession
    .getOrElse {
      SparkSession.builder()
        .master("local[*]")
        .config("spark.ui.enabled", "false")
        .config("spark.driver.bindAddress", "127.0.0.1")
        .getOrCreate()
    }
}
