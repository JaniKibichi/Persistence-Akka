name := "Persistence-Akka"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.12"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.5.12"

libraryDependencies += "org.iq80.leveldb" % "leveldb" % "0.7"

libraryDependencies += "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence-cassandra" % "0.84"