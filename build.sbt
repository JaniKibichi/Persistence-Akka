name := "Persistence-Akka"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.20"

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.20"

libraryDependencies += "com.typesafe" % "config" % "1.3.2"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence-cassandra" % "0.53"

libraryDependencies += "com.typesafe.akka" %% "akka-persistence-cassandra-launcher" % "0.53" % Test

libraryDependencies += "com.hootsuite" %% "akka-persistence-redis" % "0.8.0" % "runtime"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25"

libraryDependencies += "com.google.guava" % "guava" % "19.0"

