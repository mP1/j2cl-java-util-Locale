[![Build Status](https://travis-ci.com/mP1/java-util-Locale-j2cl.svg?branch=master)](https://travis-ci.com/mP1/java-util-Locale-j2cl.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/java-util-Locale-j2cl/badge.svg?branch=master)](https://coveralls.io/github/mP1/java-util-Locale-j2cl?branch=master)

# java.util.Locale j2cl

This project aims to provide a more complete `java.util.Locale` loading actual Locale data such as language, country and 
variant as well as extra belonging to Locale specific but classes belonging to different packages including
`java.text.DateFormatSymbol` and `java.text.DecimalFormatSymbol` using code generation.

The emulated class source will not be called `java.util.Locale` or super sourced but rather be packaged at
`walkingkooka.j2cl.java.util.Locale`. This allows unit tests to reference a real JRE `java.util.Locale` and the 
`walkingkooka.j2cl.java.util.Locale` together within a JRE environment.

An additional class is available to retrieve the Json object for a given `java.util.Locale` enabling easy retrieval of 
`java.text.DateFormatSymbol` and `java.text.DecimalFormatSymbol`.


### Missing functionality

Many methods are missing, this subset is meant to support locating a `Locale` using any combination of its components,
but without the filtering methods so it may be used as a key to retrieve additional symbol information mentioned
previously.



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
