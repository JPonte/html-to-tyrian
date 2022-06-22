ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "html-tyrian",
    libraryDependencies += "org.jsoup" % "jsoup" % "1.15.1"
  )
