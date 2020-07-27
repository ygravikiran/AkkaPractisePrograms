name := "Hello"

version := "1.0"

scalaVersion := "2.12.11"

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.1"

libraryDependencies +=    "org.scalatest" %% "scalatest" % "3.0.8" % Test
