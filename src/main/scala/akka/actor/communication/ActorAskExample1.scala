package akka.actor.communication

import akka.actor.{Actor,ActorSystem, Props};  
import akka.util.Timeout;  
import scala.concurrent.Await  
import akka.pattern.ask  
import scala.concurrent.duration._  
  
class ActorAskExample1 extends Actor{  
  def receive = {  
    case message:String => println("Message recieved: "+message);  
  }  
}  
  
object ActorAskExample1{  
  def main(args:Array[String]){  
    val actorSystem = ActorSystem("ActorSystem");  
    val actor = actorSystem.actorOf(Props[ActorAskExample1], "RootActor");  
    implicit val timeout = Timeout(2 seconds);  
    val future = actor ? "Hello";  
    val result = Await.result(future, timeout.duration);  
    println(result);  
  }  
}