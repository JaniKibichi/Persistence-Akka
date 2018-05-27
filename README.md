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
- Configure the LevelDB to be used as a journal. Create reference.conf inside src/main/resource
- Create an App to test the persisting actor:<b>com.github.janikibichi.learnakka.persistence.PersistingApp.scala</b>
- Run the App to [create a persisting actor.](https://asciinema.org/a/FiIuXpGjBlxk6qcEeMsriFct1)
