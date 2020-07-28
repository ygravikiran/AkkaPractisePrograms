package akka.actor.stop

import akka.actor.{ Actor, ActorSystem, Props };

class AkkaSystemStopExample extends Actor {
  def receive = {
    case message: String => println("Message received: " + message);
    case _ => println("Unknown message");
  }
  override def postStop() {
    println("Actor stoped");
  }
}

object AkkaSystemStopExample {
  def main(args: Array[String]) {
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[AkkaSystemStopExample], "RootActor");
    actor ! "Hello"
    actorSystem.stop(actor);
  }
}  