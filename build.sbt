name := "timetable_bot"
 
version := "1.0" 
      
lazy val `timetable_bot` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
val akkaV = "2.5.23"
      
scalaVersion := "2.12.8"

val akkaLibs = Seq(
  "com.typesafe.akka" %% "akka-contrib" % akkaV,
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.typesafe.akka" %% "akka-remote" % akkaV,
  "com.typesafe.akka" %% "akka-testkit" % akkaV,
  "com.github.romix.akka" % "akka-kryo-serialization_2.12" % "0.5.2"
)

val akkaHttp = Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10"
)

libraryDependencies ++= akkaLibs ++ akkaHttp ++ Seq( jdbc , ehcache , ws , specs2 % Test , guice,
  "org.apache.logging.log4j" % "log4j-api" % "2.12.1",
  "org.telegram" % "telegrambots" % "4.4.0.1",
  "org.scalaj" % "scalaj-http_2.12" % "2.3.0")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      