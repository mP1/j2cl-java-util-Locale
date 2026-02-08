[![Build Status](https://github.com/mP1/j2cl-java-util-Locale/actions/workflows/build.yaml/badge.svg)](https://github.com/mP1/j2cl-java-util-Locale/actions/workflows/build.yaml/badge.svg)
[![Coverage Status](https://coveralls.io/repos/github/mP1/j2cl-java-util-Locale/badge.svg)](https://coveralls.io/github/mP1/j2cl-java-util-Locale)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/j2cl-java-util-Locale.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-util-Locale/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/j2cl-java-util-Locale.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-util-Locale/alerts/)
![](https://tokei.rs/b1/github/mP1/j2cl-java-util-Locale)
[![J2CL compatible](https://img.shields.io/badge/J2CL-compatible-brightgreen.svg)](https://github.com/mP1/j2cl-central)



# j2cl java.util.Locale

This project aims to provide a mostly complete `java.util.Locale` supporting most but not all features.

- This dependency must appear in the POM before any JRE reference such as [j2cl-uber](https://github.com/mP1/j2cl-uber) so that the original `java.util.Locale` is shadowed.
- Locales with two forms such as `he` and `iw` are honoured.
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



### IDE build setup

Annotation processors from class path must be enabled as some tests test the output of generated classes.

The star/wildcard may need to be escaped with a backslash.

![Intellij -> System Preferences -> Annotation Processors](intellij-enable-annotation-processors.png)

