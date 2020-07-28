resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

lazy val akkaVersion = "2.6.8"
lazy val akkaHttpVersion = "10.1.12"


lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "akka",
      scalaVersion    := "2.12.11"
    )),
    name := "AkkaPractisePrograms",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"                % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json"     % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
      "com.typesafe.akka" %% "akka-stream"              % akkaVersion,
      "ch.qos.logback"    % "logback-classic"           % "1.2.3",

      "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"                % "3.1.0"         % Test
    )
  )
