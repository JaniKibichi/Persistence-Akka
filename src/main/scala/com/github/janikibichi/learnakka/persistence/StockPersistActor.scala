package com.github.janikibichi.learnakka.persistence

import akka.actor.{Actor, ActorLogging, Props}
import akka.persistence.{PersistentActor, RecoveryCompleted}

object StockPersistActor{
  def props(stockId: String) = Props(new StockPersistActor(stockId))
}

class StockPersistActor (stockId: String) extends PersistentActor
  with ActorLogging {
  override val persistenceId = stockId
  var state = StockHistory()

  def updateState(event: ValueAppended) = state = state.update(event)

  val receiveRecover: Receive = {
    case evt: ValueAppended =>
      updateState(evt)

    case RecoveryCompleted =>
      log.info(s"Recovery completed. current state: $state")
  }

  val receiveCommand: Receive = {
    case ValueUpdate(value) =>
      persist(ValueAppended(StockValue(value)))(updateState)

    case "print" =>
      log.info(s"Current state: $state")
  }
}
