package com.github.janikibichi.learnakka.persistence

import akka.actor.ActorSystem

object PersistentFSMApp extends App {
  val actorSystem = ActorSystem("FSMApp")

  //Create and Define an Actor in the ActorSystem
  val actorOne = createActor("uid1")

  //Send Message to Actor
  actorOne ! Initialize(4)
  actorOne ! Mark
  actorOne ! Mark

  Thread.sleep(2000)
  actorSystem.stop(actorOne)

  //Create and Define an Actor in the ActorSystem
  val actorTwo = createActor("uid2")

  //Send Message to Actor
  actorTwo ! Mark
  actorTwo ! Mark

  //CreateActor
  def createActor(id: String) =
    actorSystem.actorOf(PersistentFSMActor.props(id))
}