package com.github.janikibichi.learnakka.persistence

import akka.actor.ActorSystem
import akka.persistence.Recovery
import akka.persistence.query.PersistenceQuery
import akka.persistence.query.journal.leveldb.scaladsl.LeveldbReadJournal
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Sink
import scala.concurrent.duration._

object FriendJournalReader extends App {
  implicit val actorSystem = ActorSystem()
  import actorSystem.dispatcher
  implicit val mat = ActorMaterializer()(actorSystem)
  val queries = PersistenceQuery(actorSystem).readJournalFor[LeveldbReadJournal](LeveldbReadJournal.Identifier)

  //Create and Define an Actor in the ActorSystem
  val laura = actorSystem.actorOf(FriendActor.props("Laura", Recovery()))
  val maria = actorSystem.actorOf(FriendActor.props("Maria",Recovery()))

    //Send Messages to Actors
    laura ! AddFriend(Friend("Hector"))
    laura ! AddFriend(Friend("Nancy"))
    maria ! AddFriend(Friend("Oliver"))
    maria ! AddFriend(Friend("Steve"))

    actorSystem.scheduler.scheduleOnce(5 second, maria, AddFriend(Friend("Steve")))
    actorSystem.scheduler.scheduleOnce(10 second, maria, RemoveFriend(Friend("Oliver")))
    Thread.sleep(2000)

  //Run Queries
  queries.persistenceIds().map(id => actorSystem.log.info(s"Id received [$id]")).to(Sink.ignore).run()
  queries.eventsByPersistenceId("Laura").map(e => log(e.persistenceId, e.event)).to(Sink.ignore).run()
  queries.eventsByPersistenceId("Maria").map(e => log(e.persistenceId, e.event)).to(Sink.ignore).run()

  def log(id: String, evt: Any) = actorSystem.log.info(s"Id [$id] Event [$evt]")

}
