val kamonCore     = "io.kamon"      %% "kamon-core"                % "1.1.6"
val kamonTestKit  = "io.kamon"      %% "kamon-testkit"             % "1.1.6"
val awsXrayCore   = "com.amazonaws" % "aws-xray-recorder-sdk-core" % "2.2.1"

lazy val root = (project in file("."))
  .settings(name := "kamon-xray")
  .settings(mavenCentral: _*)
  .settings(
    libraryDependencies ++=
      compileScope(kamonCore, awsXrayCore, scalaCompact.value) ++
      testScope(scalatest, slf4jApi, slf4jnop, kamonCore, kamonTestKit)
  )

def scalaCompact = Def.setting {
  scalaBinaryVersion.value match {
    case "2.10" | "2.11" => "org.scala-lang.modules" %% "scala-java8-compat" % "0.5.0"
    case "2.12"          => "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0"
  }
}

lazy val mavenCentral = Seq(
  organization := "com.github.yoshiyoshifujii",
  sonatypeProfileName := "com.github.yoshiyoshifujii",
  publishMavenStyle := true,
  publishTo := sonatypePublishTo.value,
  credentials := {
    val ivyCredentials = (baseDirectory in LocalRootProject).value / ".credentials"
    Credentials(ivyCredentials) :: Nil
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ =>
    false
  },
  pomExtra := {
    <url>https://github.com/yoshiyoshifujii/kamon-xray</url>
      <scm>
        <url>git@github.com:yoshiyoshifujii/kamon-xray.git</url>
        <connection>scm:git:github.com/yoshiyoshifujii/kamon-xray</connection>
        <developerConnection>scm:git:git@github.com:yoshiyoshifujii/kamon-xray.git</developerConnection>
      </scm>
      <developers>
        <developer>
          <id>yoshiyoshifujii</id>
          <name>Yoshitaka Fujii</name>
        </developer>
      </developers>
  }
)
