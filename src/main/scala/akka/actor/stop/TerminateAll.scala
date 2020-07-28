package akka.actor.stop

import akka.actor.{ Actor, ActorSystem, Props };

class TerminateAll extends Actor {
  def receive = {
    case message: String =>
      println("Message received by " + self.path.name + ": " + message);
      val childactor = context.actorOf(Props[ChildActor2], "ChildActor");
      childactor ! "Hello child Actor"

    case _ => println("Unknown message");
  }

  override def postStop() {
    println("Top Level Actor stoped");
  }
}

class ChildActor2 extends Actor {
  def receive = {
    case message: String => println("Message received by " + self.path.name + ": " + message);
    case _ => println("Unknown message");
  }

  override def postStop() {
    println("Child Actor stoped");
  }
}

object TerminateAll {
  def main(args: Array[String]) {
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[TerminateAll], "RootActor");
    actor ! "Hello"
    actorSystem.terminate();
  }
}  