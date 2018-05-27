package com.github.janikibichi.learnakka.persistence

import akka.actor.ActorSystem
import akka.persistence.{Recovery, SnapshotSelectionCriteria}

object FriendApp extends App {
  val actorSystem = ActorSystem("AppOne")
  //Create and Define An Actor in the ActorSystem
  val helloFriend = actorSystem.actorOf(FriendActor.props("Graham", Recovery()))
  //Send Messages to Actors
  helloFriend ! AddFriend(Friend("Laura"))
  helloFriend ! AddFriend(Friend("Nancy"))
  helloFriend ! AddFriend(Friend("Oliver"))
  helloFriend ! AddFriend(Friend("Steve"))
  helloFriend ! "snap"
  helloFriend ! RemoveFriend(Friend("Laura"))
  helloFriend ! "print"

  Thread.sleep(2000)
  actorSystem.terminate()
}

object FriendDefaultRecovery extends App {
  val actorSystem = ActorSystem("AppOne")

  //Create and define Actor in ActorSystem
  val helloFriend = actorSystem.actorOf(FriendActor.props("Graham", Recovery()))

  //Send Message to Actor
  helloFriend ! "print"

  Thread.sleep(2000)
  actorSystem.terminate()
}

object OnlyEventRecovery extends App {
  val actorSystem = ActorSystem("AppOne")

  //How not to recover from snapshots but only from events
  val recovery = Recovery(fromSnapshot = SnapshotSelectionCriteria.None)

  //Create and Define an Actor in the ActorSystem
  val helloFriend = actorSystem.actorOf(FriendActor.props("Graham", recovery))

  //Send Message to actor
  helloFriend ! "print"

  Thread.sleep(2000)
  actorSystem.terminate()
}

object FriendRecoveryEventsSequence extends App {
  val actorSystem = ActorSystem("AppOne")

  //Place a Limit up to which event is recovered
  val recovery = Recovery(fromSnapshot = SnapshotSelectionCriteria.None, toSequenceNr=2)

  //Create and define an Actor in an ActorSystem
  val helloFriend = actorSystem.actorOf(FriendActor.props("Graham", recovery))

  Thread.sleep(2000)
  actorSystem.terminate()
}

object FriendRecoveryEventsReplay extends App{
  val actorSystem = ActorSystem("AppOne")

  //Limit how many events to replay
  val recovery = Recovery(fromSnapshot = SnapshotSelectionCriteria.None, replayMax = 3)

  //Create and define and Actor in an ActorSystem
  val helloFriend = actorSystem.actorOf(FriendActor.props("Graham", recovery))

  Thread.sleep(2000)
  actorSystem.terminate()
}

