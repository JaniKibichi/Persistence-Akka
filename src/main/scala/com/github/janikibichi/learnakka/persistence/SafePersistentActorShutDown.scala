package com.github.janikibichi.learnakka.persistence

import akka.actor.{ActorSystem, PoisonPill, Props}

object SafePersistentActorShutDown extends App {
  val actorSystem = ActorSystem("SafeShutDown")

  //Create and Define Actor in ActorSystem
  val persistActorOne = actorSystem.actorOf(Props[PersistingActor])
  val persistActorTwo = actorSystem.actorOf(Props[PersistingActor])

  //Send Message to Actor
  persistActorOne ! UserUpdate("foo", Add)
  persistActorOne ! UserUpdate("foo", Add)
  persistActorOne ! PoisonPill

  persistActorTwo ! UserUpdate("foo", Add)
  persistActorTwo ! UserUpdate("foo", Add)
  persistActorTwo ! ShutdownPersistentActor
}
