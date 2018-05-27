# Persisting Actor State
The state held by stateful actors may require to be persisted, or may be needed even after the actor fails or restarts.
State can be lost if:
- the Actor is restarted
- the Actor is migrated to a different node
- the JVM crashes

Akka persistence uses event sourcing to save Actor state and then recover it.

#### Some important concepts for actor persistence:
- PersistentActor: a stateful actor that persists events to a journal. Entries that can be replayed to the actor to recover state, in case of failure.

- AsyncWriteJournal: A journal with an ordered collection of events that can be sent to a persistent actor.

- AtLeastOnceDelivery: A message delivery mechanism that ensures at least one time delivery to destinations.

- Snapshot store: Store of snapshots of actor state, used to speed up recovery time for state.

<br><br>
- Branch out to explore simple use of a persisting actor
````
git checkout -b start_persisting master
````
- Create the file to handle the persisting model: <b>com.github.janikibichi.learnakka.persistence.APersistingModel.scala</b>
- Add akka-persistence and levelDB dependencies to build.sbt
````
libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.5.12"
libraryDependencies += "org.iq80.leveldb" % "leveldb" % "0.10"

````
- Create a file to handle the persisting actor: <b>com.github.janikibichi.learnakka.persistence.APersistingActor.scala</b>
- Configure the LevelDB to be used as a journal. Create reference.conf inside src/main/resources
- Create an App to test the persisting actor:<b>com.github.janikibichi.learnakka.persistence.PersistingApp.scala</b>
- Run the App to [create a persisting actor.](https://asciinema.org/a/YrjjDlbBzFxqe95NH3hYQaG1z)

<br><br>
- Branch out to explore recovering the state of an actor
````
git checkout -b recover_state start_persisting
````
- Create the file to handle the persisting model: <b>com.github.janikibichi.learnakka.persistence.RecoverState.scala</b>
- Create the file to model friends data:<b>com.github.janikibichi.learnakka.persistence.FriendModel.scala</b>
- Create the file to describe actor:<b>com.github.janikibichi.learnakka.persistence.FriendActor.scala</b>
- Create the file to recover state:<b>com.github.janikibichi.learnakka.persistence.FriendApp.scala</b>
- Update the file reference.conf in src/main./resources
- Add levelDB dependency in build.sbt:
````
libraryDependencies += "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8"
````
- Run the App to [recover state of the actor.](https://asciinema.org/a/bCEsm9IfiJiVQG9vqYXm3rcin)

<br><br>
- Branch out to explore shutting down persistent actor
````
git checkout -b shut_down_persistent_actor recover_state
````
- Update APersistingModel.scala and APersistingActor.scala
- Create the file to define actor: <b>com.github.janikibichi.learnakka.persistence.SafePersistentActorShutDown.scala</b>
- Run the App to [shut down persistent actor.](https://asciinema.org/a/YGjVuPXA3eSZigF7ZR3MLzMjc)

<br><br>
- Branch out to explore recovery with snapshots
````
git checkout -b recovery_with_snapshots shut_down_persistent_actor
````
- Create file to define snapshot capabilities: <b>com.github.janikibichi.learnakka.persistence.SnapshotActor.scala</b>
- Create snapshot app: <b>com.github.janikibichi.learnakka.persistence.SnapshotApp.scala</b>
- Run the App to [recover with snapshots.](https://asciinema.org/a/AuI2IVMdCs7hO0ksHX8ogNMjt)

<br><br>
- Branch out to explore creating a persistence FSM model
````
git checkout -b persist_FSM_model recovery_with_snapshots 
````
- Create file to define FSM Model: <b>com.github.janikibichi.learnakka.persistence.PersistentFSMModel.scala</b>
- Create actor to use FSM states: <b>com.github.janikibichi.learnakka.persistence.PersistentFSMActor.scala</b>
- Create app test FSM actor: <b>com.github.janikibichi.learnakka.persistence.PersistentFSMApp.scala</b>
- Run the App to [run Persisting FSM Actor.](https://asciinema.org/a/AuI2IVMdCs7hO0ksHX8ogNMjt)



