[![Build Status](https://travis-ci.com/mP1/j2cl-java-util-Locale.svg?branch=master)](https://travis-ci.com/mP1/j2cl-java-util-Locale.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/j2cl-java-util-Locale/badge.svg?branch=master)](https://coveralls.io/github/mP1/j2cl-java-util-Locale?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/j2cl-java-util-Locale.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-util-Locale/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/j2cl-java-util-Locale.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-util-Locale/alerts/)



# j2cl java.util.Locale

This project aims to provide a mostly complete `java.util.Locale` supporting parsing of language tags and extracting
individual components as well as a helper to simply a locale and try again from a tag to value source. The `Locale`
will honour some languages which have two forms such as `he` and its alternate form `iw` with the getter always
resolving to `iw` to match the JRE behaviour.

Generally complex variants such as `ja-JP-u-ca-japanese-x-lvariant-JP` and unusual exceptions such as `no-NO-NY` remain
unknown and behaviour such as `Locale#toLanguageTag` will be different. WHen attempting to locate `DateFormatSymbols`
the locales mention in the previous sentence slightly different representation should not matter because the actual
resolving will only use the language and country.



### Missing functionality

Many methods are missing, this subset is meant to support locating a `Locale` using any combination of its components.
All `Locale` constants except for `ROOT` are not available to fetch a selected `Locale` use `Locale.forLanguageTag`.


### Transpiling

The `j2cl-maven-plugin` will shade the source during the transpile phase, so `walkingkooka.j2cl.java.util.Locale`
is available to the runtime as `java.util.Locale`. 



### Serialization

Serialization is not supported, and all support classes and forms including magic methods such as `writeReplace` are removed.



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

