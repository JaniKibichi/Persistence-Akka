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

- AtLeastOnceDelivery: A message delivery mechanism that ensures at least one time deilivery to destinations.

- Snapshot store: Store of snapshots of actor state, used to speed up recovery time for state.
