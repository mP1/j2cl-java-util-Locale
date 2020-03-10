[![Build Status](https://travis-ci.com/mP1/java-util-Locale-j2cl.svg?branch=master)](https://travis-ci.com/mP1/java-util-Locale-j2cl.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/java-util-Locale-j2cl/badge.svg?branch=master)](https://coveralls.io/github/mP1/java-util-Locale-j2cl?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/java-util-Locale-j2cl.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/java-util-Locale-j2cl/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/java-util-Locale-j2cl.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/java-util-Locale-j2cl/alerts/)



# java.util.Locale j2cl

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


### Transpiling

The `j2cl-maven-plugin` will repackage the source during the transpile phase, so `walkingkooka.javautillocalej2cl.java.util.Locale`
is available to the runtime as `java.util.Locale`. 



### Serialization

Serialization is not supported, and all support classes and forms including magic methods such as `writeReplace` are removed.



## Getting the source

You can either download the source using the "ZIP" button at the top
of the github page, or you can make a clone using git:

```
git clone git://github.com/mP1/java-util-Locale-j2cl.git
```
