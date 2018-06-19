name := "Persistence-Akka"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.12"

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.5.12"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.5.12"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence-query" % "2.5.12"

libraryDependencies += "com.typesafe" % "config" % "1.3.2"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25"

libraryDependencies += "com.google.guava" % "guava" % "19.0"

libraryDependencies += "org.iq80.leveldb" % "leveldb" % "0.10"

libraryDependencies += "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8"
