## Installation

You can add `creative-api` to your project using [Gradle](https://gradle.org/)
*(recommended)*, [Maven](https://maven.apache.org/) or manually downloading the
JAR files


### Gradle
```kotlin
repositories {
    maven("https://repo.unnamed.team/repository/unnamed-public/")
}
```
```kotlin
dependencies {
    implementation("team.unnamed:creative-api:0.1.12-SNAPSHOT")
}
```


### Maven

```xml
<repository>
    <id>unnamed-public</id>
    <url>https://repo.unnamed.team/repository/unnamed-public/</url>
</repository>
```
```xml
<dependency>
    <groupId>team.unnamed</groupId>
    <artifactId>creative-api</artifactId>
    <version>0.1.12-SNAPSHOT</version>
</dependency>
```