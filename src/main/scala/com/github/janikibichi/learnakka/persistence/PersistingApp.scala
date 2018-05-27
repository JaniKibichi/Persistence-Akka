package com.github.janikibichi.learnakka.persistence

import akka.actor.{ActorSystem, Props}

object PersistingApp extends App{

  val actorSystem = ActorSystem("persistingActor")

  //Create and Define an Actor in the ActorSystem
  val actorPersistOne = actorSystem.actorOf(Props[PersistingActor])

  //Send Messages to the Actor 1
  actorPersistOne ! UserUpdate("foo", Add)
  actorPersistOne ! UserUpdate("baz", Add)
  actorPersistOne ! "snap"
  actorPersistOne ! "print"
  actorPersistOne ! UserUpdate("baz", Remove)
  actorPersistOne ! "print"
  Thread.sleep(2000)

  actorSystem.stop(actorPersistOne)

  //Create and Define An Actor in the ActorSystem
  val actorPersistTwo = actorSystem.actorOf(Props[PersistingActor])

  //Send Messages to the Persist Actor
  actorPersistTwo ! "print"
  Thread.sleep(2000)

  //Terminate the actorSystem
  actorSystem.terminate()
}