import sbtassembly.AssemblyKeys.assemblyMergeStrategy
import sbtassembly.{MergeStrategy, PathList}

name := "scala-sbt-template"

version := "1.0"

scalaVersion := "2.11.12"

sourcesInBase := true

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "2.4.0" % Provided,
  "org.apache.hadoop" % "hadoop-aws" % "2.7.3" exclude
    ("com.fasterxml.jackson", "jackson-core") exclude
    ("com.fasterxml.jackson", "jackson-annotations") exclude
    ("com.fasterxml.jackson", "jackson-databind"),
  "org.apache.hadoop" % "hadoop-common" % "2.7.3",

  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.7",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7",

  "org.scala-lang" % "scala-reflect" % "2.11.12" % Provided,
  "com.github.scopt" %% "scopt" % "3.4.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test)

assemblyMergeStrategy in assembly := {
  case PathList("org", "apache", "commons", _*) => MergeStrategy.last
  case PathList("org", "apache", "log4j", _*) => MergeStrategy.last
  case "mozilla/public-suffix-list.txt" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
