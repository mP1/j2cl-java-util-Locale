[![Build Status](https://travis-ci.com/mP1/j2cl-java-util-Locale.svg?branch=master)](https://travis-ci.com/mP1/j2cl-java-util-Locale.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/j2cl-java-util-Locale/badge.svg?branch=master)](https://coveralls.io/github/mP1/j2cl-java-util-Locale?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/j2cl-java-util-Locale.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-util-Locale/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/j2cl-java-util-Locale.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-util-Locale/alerts/)



# j2cl java.util.Locale

This project aims to provide a mostly complete `java.util.Locale` supporting most but not all features.

- Locales with two forms such as `he` and `iw` is honoured.
- Complex Locales which include variants such as `ja-JP-u-ca-japanese-x-lvariant-JP` are not supported.
- Unusual exceptions such as `no-NO-NY` remain.
- `java.util.Locale#toLanguageTag` should be basically the same.
- `java.util.Locale#forLanguage` is limited to parsing language tags without variants and works best with only language, country and script components.
- Serialization is not supported, and all support classes and forms including magic methods such as `writeReplace` are removed.



## Annotation processor arguments

- See [j2cl-java-util-locale-annotation-processor](https://github.com/mP1/j2cl-java-util-locale-annotation-processor) for more info about selecting which locales get bundled.
- See [j2cl-locale](https://github.com/mP1/j2cl-locale) for more info about logging.



## Missing/Unsupported APIs

`java.util.Locale`

- All constants except ROOT have been removed, use `java.util.Locale#forLanguageTag`
- All filter* methods have been removed
- All getDisplay* methods have been removed.
- getUnicode* removed
- hasExtensions removed
- scriptExtensions removed

`java.util.Locale.Builder`

- Not available, issue to create [issue#103](https://github.com/mP1/j2cl-java-util-Locale/issues/103)

`java.util.Locale.Category`

- Not available

`java.util.Locale.FilteringMode`

- Not available

`java.util.Locale.LanguageRange`

- Not available



## Transpiling

The `j2cl-maven-plugin` will shade the source during the transpile phase, so `walkingkooka.j2cl.java.util.Locale`
is available to the runtime as `java.util.Locale`. 



## Getting the source

You can either download the source using the "ZIP" button at the top
of the github page, or you can make a clone using git:

```
git clone git://github.com/mP1/j2cl-java-util-Locale.git
```


### IDE build setup

Annotation processors from class path must be enabled as some tests test the output of generated classes.

The star/wildcard may need to be escaped with a backslash.

![Intellij -> System Preferences -> Annotation Processors](intellij-enable-annotation-processors.png)

