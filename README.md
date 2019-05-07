AWS X-Ray Integration
=============================

[![Build Status](https://travis-ci.org/yoshiyoshifujii/kamon-xray.svg?branch=master)](https://travis-ci.org/yoshiyoshifujii/kamon-xray)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yoshiyoshifujii/kamon-xray_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.yoshiyoshifujii/kamon-xray_2.12)

Reporting Metrics to AWS X-Ray
======================================

[AWS X-Ray](https://aws.amazon.com/xray/) helps developers analyze and debug production, distributed applications, such as those built using a microservices architecture.

### Getting Started

Supported releases and dependencies are shown below.

| kamon-xray        | status | jdk  | scala            |
|:-----------------:|:------:|:----:|------------------|
|  0.1.0            | stable | 1.8+ | 2.10,2.11,2.12   |

To get started with SBT, simply add the following to your `build.sbt` file:

```scala
libraryDependencies += "com.github.yoshiyoshifujii" %% "kamon-xray" % "0.1.0"
```

And add the API reporter to Kamon:

```scala
implicit val system: ActorSystem = ActorSystem()

Kamon.addReporter(XRayAPIReporter()(system.dispatchers.lookup("blocking-io-dispatcher-xray")))
```

Configuration
-------------

To specify AWS X-Ray region, please write it in `application.conf` as follows.

```application.conf
kamon {

  xray {

    region = "us-east-1"

    namespace = "Kamon"

  }
}
```
