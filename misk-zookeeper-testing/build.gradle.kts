import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension
plugins {
  kotlin("jvm")
  `java-library`
}

buildscript {
  dependencies {
    classpath(Dependencies.kotlinAllOpenPlugin)
    classpath(Dependencies.kotlinNoArgPlugin)
  }
}

apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
apply(plugin = "kotlin-jpa")

configure<AllOpenExtension> {
  annotation("javax.persistence.Entity")
  annotation("javax.persistence.Embeddable")
  annotation("javax.persistence.MappedSuperclass")
}

dependencies {
  implementation(Dependencies.curatorFramework) {
    exclude(group = "org.slf4j", module = "slf4j-log4j12")
    exclude(group = "log4j", module = "log4j")
  }
  implementation(Dependencies.zookeeper) {
    exclude(group = "org.slf4j", module = "slf4j-log4j12")
    exclude(group = "log4j", module = "log4j")
  }
  implementation(Dependencies.dockerCore)
  implementation(Dependencies.dockerTransport)
  implementation(Dependencies.guice)
  api(project(":misk"))
  api(project(":misk-core"))
  api(project(":misk-inject"))
  api(project(":misk-service"))
  api(project(":misk-testing"))
  api(project(":misk-zookeeper"))
  api(Dependencies.wispContainersTesting)
}
