package akka.actor.example

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props;  
import akka.actor.actorRef2Scala
import com.typesafe.scalalogging.StrictLogging

class HelloAkka extends Actor with StrictLogging{    // Extending actor trait  
  def receive = {                 //  Receiving message  
    case msg:String => println(msg)  
    case _ =>logger.info("Unknown message")      // Default case  
  }  
}  
  
object Main{  
  def main(args:Array[String]){  
    var actorSystem = ActorSystem("Main");                       // Creating ActorSystem  
   var actor = actorSystem.actorOf(Props[HelloAkka],"HelloAkka")        //Creating actor  
    actor ! "Hello Akka"                                                // Sending messages by using !  
    actor ! 100.52  
  }  
}