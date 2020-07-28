package akka.actor.example

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
class PropsExample extends Actor {
  def receive = {
    case msg: String => println(msg + " " + self.path.name)
  }
}
object PropsMain {
  def main(args: Array[String]) {
    var actorSystem = ActorSystem("ActorSystem");
    var actor = actorSystem.actorOf(Props[PropsExample], "PropExample");
    actor ! "Hello from"
  }
}  