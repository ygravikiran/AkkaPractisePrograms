package akka.actor.communication

import akka.actor.{Actor,ActorSystem, Props};  
import akka.util.Timeout;  
import scala.concurrent.Await  
import akka.pattern.ask  
import scala.concurrent.duration._  
  
class ActorAskExample3 extends Actor{  
  def receive = {  
    case message:String => println("Message received: "+message+" from outside actor instance");  
    Thread.sleep(5000);      // actor thread is sleeping   
    println("Replaying");  
    val senderName = sender();  
    senderName ! "Hello, I got your message.";      // Replying message  
  }  
}  
  
object ActorAskExample3{  
  def main(args:Array[String]){  
    val actorSystem = ActorSystem("ActorSystem");  
    val actor = actorSystem.actorOf(Props[ActorAskExample3], "RootActor");  
    implicit val timeout = Timeout(2 seconds);  
    val future = actor ? "Hello";  
    val result = Await.result(future, timeout.duration);  
    println("Message received: "+result);  
  }  
}  