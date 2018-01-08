import commondeps.Dependencies._

val vAll = Versions(versions, libraries, scalacPlugins)


lazy val shapelessx = crossProject.crossType(CrossType.Pure).in(file("shared"))
  .settings(name := "shapelessx", organization := "com.github.benhutchison")
  .settings(scalaVersion := vAll.vers("scalac"))
  .settings(addCompilerPlugins(vAll, "kind-projector"))
  .settings(addLibs(vAll,
    "shapeless"
  ))
  .settings(scalacOptions ++= scalacAllOptions)

lazy val projJS = shapelessx.js
lazy val projJVM = shapelessx.jvm

lazy val shapelessxRoot = project.in(file(".")).
  aggregate(projJS, projJVM).
  settings(noPublishSettings)