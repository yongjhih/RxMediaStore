# RxMediaStore

[![Download](https://api.bintray.com/packages/yongjhih/maven/RxMediaStore/images/download.svg) ](https://bintray.com/yongjhih/maven/RxMediaStore/_latestVersion)
[![JitPack](https://img.shields.io/github/tag/yongjhih/RxMediaStore.svg?label=JitPack)](https://jitpack.io/#yongjhih/RxMediaStore)
[![Build Status](https://travis-ci.org/yongjhih/RxMediaStore.svg)](https://travis-ci.org/yongjhih/RxMediaStore)
[![Join the chat at https://gitter.im/yongjhih/RxMediaStore](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/yongjhih/RxMediaStore?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

![](art/RxMediaStore.png)

MediaStore with AutoCursor in RxJava.

## Usage

```java
Observable<Image> images = MediaStoreObservable.images(context);
images.subscribe(System.out::println);
```

Ready Image.java:

```java
@AutoCursor
public abstract class Image implements Parcelable {
    @Nullable
    @AutoCursor.Column(name = _ID)
    public abstract Long id();

    @Nullable
    @AutoCursor.Column(name = DATA)
    public abstract String data();
 
    @Nullable
    @AutoCursor.Column(name = BUCKET_DISPLAY_NAME)
    public String bucketDisplayName();

    @Nullable
    @AutoCursor.Column(name = BUCKET_ID)
    public Long bucketId();

    // ...

    public static Image create(Cursor cursor) {
        return new AutoCursor_Image(cursor);
    }
}
```

## Installation

via jcenter:

```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'com.infstory:rx-media-store:1.0.0'
}
```

via jitpack.io:

```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.yongjhih.RxMediaStore:rx-media-store:-SNAPSHOT'
}
```

## License

```
Copyright 2015 8tory, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
