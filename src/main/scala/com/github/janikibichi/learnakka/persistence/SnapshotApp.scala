package com.github.janikibichi.learnakka.persistence

import akka.actor.{ActorSystem, Props}

object SnapshotApp extends App {
  val actorSystem = ActorSystem("snapshot")

  //Create and Define Actor in ActorSystem
  val persistentActorOne = actorSystem.actorOf(Props[SnapshotActor])

  //Send a message to the Actor 1
  persistentActorOne ! UserUpdate("user1",Add)
  persistentActorOne ! UserUpdate("user2",Add)
  persistentActorOne ! "snap"

  Thread.sleep(2000)
  actorSystem.stop(persistentActorOne)

  //Send a message to Actor 2
  val persistentActorTwo = actorSystem.actorOf(Props[SnapshotActor])

  Thread.sleep(2000)
  actorSystem.terminate()
}
