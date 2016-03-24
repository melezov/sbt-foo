scalaVersion in ThisBuild := "2.11.8"

lazy val first = project

lazy val second = project dependsOn(first) settings (
  fullClasspath in Compile := (fullClasspath in Compile).value filterNot { file =>
    file.data.getPath.replace("\\", "/") endsWith("/first/lib/my-lib.jar")
  } 
)
