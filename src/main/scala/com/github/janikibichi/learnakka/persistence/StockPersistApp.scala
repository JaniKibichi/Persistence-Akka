package com.github.janikibichi.learnakka.persistence

trait AkkaHelper {
  lazy val actorSystem = akka.actor.ActorSystem("StockPersist")

  //Create and Define an Actor in the ActorSystem
  lazy val teslaStockActor = actorSystem.actorOf(StockPersistActor.props("TLSA"))
}

object StockPersistApp extends App with AkkaHelper {
  teslaStockActor ! ValueUpdate(305.12)
  teslaStockActor ! ValueUpdate(305.15)
  teslaStockActor ! "print"

  Thread.sleep(5000)
  actorSystem.terminate()
}

object StockRecoveryApp extends App with AkkaHelper {
  teslaStockActor ! ValueUpdate(305.20)
  teslaStockActor ! "print"

  Thread.sleep(2000)
  actorSystem.terminate()
}