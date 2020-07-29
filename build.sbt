resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Maven Repository" at "https://mvnrepository.com/artifact/io.spray/spray-routing"

lazy val akkaVersion = "2.6.8"
lazy val akkaHttpVersion = "10.1.12"


lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "akka",
      scalaVersion    := "2.11.8"
    )),
    name := "AkkaPractisePrograms",
  libraryDependencies ++= {
  val akkaV = "2.3.6"
  val sprayV = "1.3.2"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV withSources() withJavadoc(),
    "io.spray"            %%  "spray-routing" % sprayV withSources() withJavadoc(),
    "io.spray"            %%  "spray-json"    % "1.3.1",
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
    "org.scalaz"          %%  "scalaz-core"   % "7.1.0"
  )
}
 
  )

  
  