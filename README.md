# Essential Testing

a.k.a., **Writing Programs That Write Tests: Better Testing With ScalaCheck**.

## Setup

[Install `sbt`](https://www.scala-sbt.org/release/docs/Setup.html), then run it:

> $ sbt

From the `sbt` prompt, you can run tests:

> sbt:essential-testing-code> test

All code should compile, but there may be some compiler warnings about unused imports or dead code, because the exercises have placeholders for you to complete.

You can also run a specific test by name:

> sbt:essential-testing-code> testOnly AbsSpec