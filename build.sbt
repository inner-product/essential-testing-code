scalaVersion := "2.12.10"

libraryDependencies ++=
  Seq(
    "org.scalacheck" %% "scalacheck" % "1.14.0")

scalacOptions ++= Seq(
  "-encoding", "UTF-8", // 2 args
  "-feature",
  "-deprecation",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xlint",
  "-Ypartial-unification",
  "-Ywarn-dead-code",
  "-Ywarn-unused:imports",
  "-Ywarn-value-discard"
)

scalacOptions in (Compile, console) ~= (_.filterNot(
  Set(
    "-Ywarn-unused:imports",
    "-Xfatal-warnings"
  )))