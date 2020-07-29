package akka.actor.communication

import akka.actor.{Actor,ActorSystem, Props, ActorRef};  
import akka.util.Timeout;  
import scala.concurrent.Await  
import akka.pattern.ask  
import scala.concurrent.duration._  
  
class ActorAskExample2 extends Actor{  
  def receive = {  
    case message:String => println("Message received: "+message+" from outside actor instance");  
    println("Replaying");  
    val senderName = sender();  
    senderName ! "Hello, I got your message.";      // Replying message  
  }  
}  
  
object ActorAskExample2{  
  def main(args:Array[String]){  
    val actorSystem = ActorSystem("ActorSystem");  
    val actor = actorSystem.actorOf(Props[ActorAskExample2], "RootActor");  
    implicit val timeout = Timeout(10 seconds);  
    val future = actor ? "Hello";  
    val result = Await.result(future, timeout.duration);  
    println("Message received: "+result);  
  }  
}  