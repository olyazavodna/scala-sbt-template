credentials += Credentials(Path.userHome / ".sbt" / ".credentials")
resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")
