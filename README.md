jiphy
========

[![Apache License](http://img.shields.io/badge/license-ASL-blue.svg)](https://github.com/brunocvcunha/jiphy/blob/master/LICENSE)
[![Build Status](https://travis-ci.org/brunocvcunha/jiphy.svg)](https://travis-ci.org/brunocvcunha/jiphy)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.brunocvcunha.jiphy/jiphy/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.brunocvcunha.jiphy/jiphy)
[![Coverage Status](https://coveralls.io/repos/github/brunocvcunha/jiphy/badge.svg?branch=master)](https://coveralls.io/github/brunocvcunha/jiphy?branch=master)  [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](http://makeapullrequest.com)

:movie_camera: jiphy - Java Wrapper for Giphy API


Usage
--------

Download [the latest release JAR][1] or grab via Maven:
```xml
<dependency>
  <groupId>org.brunocvcunha.jiphy</groupId>
  <artifactId>jiphy</artifactId>
  <version>1.0</version>
</dependency>
```
or Gradle:
```groovy
compile 'org.brunocvcunha.jiphy:jiphy:1.0'
```



Supported Operations & Examples
--------

#### Initialize

```java
Jiphy jiphy = Jiphy.builder()
    .apiKey(JiphyConstants.API_KEY_BETA)
    .build();
```

#### Search

```java
JiphySearchResponse cats = jiphy.sendRequest(new JiphySearchRequest("cats"));

for (JiphyGif gif : cats.getData()) {
    System.out.println("Cat: " + gif.getUrl());
}
```

#### Trending

```java
JiphySearchResponse trending = jiphy.sendRequest(new JiphyTrendingRequest());
```


#### Translate

```java
JiphySearchResponse superman = jiphy.sendRequest(new JiphyTranslateRequest("superman"));
```

#### Upload

```java
JiphyUploadResult upload = jiphy.sendRequest(new JiphyUploadRequest(new File("/path/to/cats.gif")));
System.out.println("Uploaded, id: " + upload.getData().getId());
```



Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

jiphy requires at minimum Java 8.


 [1]: https://search.maven.org/remote_content?g=org.brunocvcunha.jiphy&a=jiphy&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
