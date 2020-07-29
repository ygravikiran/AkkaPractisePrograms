package akka.actor.stop

import akka.actor.{Actor,ActorSystem, Props};  
  
class AkkaChildActorStopExample extends Actor{  
  def receive = {  
    case message:String => println("Message received by "+self.path.name+": "+message);  
    val childactor = context.actorOf(Props[ChildActor], "ChildActor");  
    childactor ! "Hello child Actor"  
    context.stop(childactor);  
      
    case _ => println("Unknown message");  
  }  
}  
  
  
class ChildActor extends Actor{  
  def receive = {  
    case message:String => println("Message received by "+self.path.name+": "+message);  
    case _ => println("Unknown message");  
  }  
    
  override def postStop(){  
    println("Child Actor stoped");  
  }  
}  
  
  
object AkkaChildActorStopExample{  
  def main(args:Array[String]){  
    val actorSystem = ActorSystem("ActorSystem");  
    val actor = actorSystem.actorOf(Props[AkkaChildActorStopExample], "RootActor");  
    actor ! "Hello"  
      
  }  
}