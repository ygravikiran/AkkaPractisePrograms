package akka.actor.replay

import akka.actor.{ Actor, ActorSystem, Props };
class ActorReplyExample extends Actor {
  def receive = {
    case message: String =>
      println("Message recieved from " + sender.path.name + " message: " + message);
      val child = context.actorOf(Props[ActorChildReplyExample], "ActorChild");
      child ! "Hello Child"
  }
}

class ActorChildReplyExample extends Actor {
  def receive = {
    case message: String =>
      println("Message recieved from " + sender.path.name + " message: " + message);
      println("Replying to " + sender().path.name);
      sender() ! "I got you message";
  }
}

object ActorReplyExample {
  def main(args: Array[String]) {
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorReplyExample], "RootActor");
    actor ! "Hello";
  }
}  