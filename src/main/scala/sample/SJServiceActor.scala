package sample

import akka.actor.Actor
import spray.http._
import spray.http.MediaTypes._
import spray.json.DefaultJsonProtocol
import spray.routing._
 
 
// simple actor that handles the routes.
class SJServiceActor extends Actor with HttpService {
 
  // required as implicit value for the HttpService
  // included from SJService
  def actorRefFactory = context
 
  // we don't create a receive function ourselve, but use
  // the runRoute function from the HttpService to create
  // one for us, based on the supplied routes.
  def receive = runRoute(aSimpleRoute ~ anotherRoute)

  
  // handles the other path, we could also define these in separate files
  // This is just a simple route to explain the concept
  val aSimpleRoute = {
    path("path1") {
      get {
        // respond with text/html.
        respondWithMediaType(`text/html`) {
          complete {
            // respond with a set of HTML elements
            <html>
              <body>
                <h1>Path 1</h1>
              </body>
            </html>
          }
        }
      }
    }
  }
  
  // handles the other path, we could also define these in separate files
  // This is just a simple route to explain the concept
  val anotherRoute = {
    path("path2") {
      get {
        // respond with text/html.
        respondWithMediaType(`text/html`) {
          complete {
            // respond with a set of HTML elements
            <html>
              <body>
                <h1>Path 2</h1>
              </body>
            </html>
          }
        }
      }
    }
  }
  
  
  
  
}