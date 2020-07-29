package akka.actor.communication

import akka.actor.{Actor,ActorSystem, Props};  
  
class ActorTellExample1 extends Actor{  
  def receive = {  
    case message:String => println("Message received: "+message+ " from - "+ self.path.name);   
    println("sender:"+ sender());  // returns ActorRef  
  }  
}  
  
object ActorTellExample1{  
  def main(args:Array[String]){  
    val actorSystem = ActorSystem("ActorSystem");  
    val actor = actorSystem.actorOf(Props[ActorTellExample1], "RootActor");  
    actor ! "Hello"             // Sending message by using !  
    actor.tell("Hello",null);  // Sending message by using tell() method  
                    // Sender is not passed here.  
  }  
}  