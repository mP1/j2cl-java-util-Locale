/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.j2cl;

import org.junit.jupiter.api.Test;
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.ToStringTesting;
import walkingkooka.collect.map.Maps;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class WalkingkookaLanguageTagTest implements ClassTesting<WalkingkookaLanguageTag>,
    HashCodeEqualsDefinedTesting2<WalkingkookaLanguageTag>,
        ToStringTesting<WalkingkookaLanguageTag> {

    private final static String TAG = "en-AU-NSW";
    private final static String LANGUAGE = "en";
    private final static String COUNTRY = "AU";
    private final static String VARIANT = "NSW";

    @Test
    public void testParseEmpty() {
        this.parseAndCheck("", "", "", "", "");
    }

    @Test
    public void testParseLanguageUpperCase() {
        this.parseAndCheck("EN", "en", "", "", "");
    }

    @Test
    public void testParseLanguageMixedCase() {
        this.parseAndCheck("En", "en", "", "", "");
    }

    @Test
    public void testParseLanguageLowerCase() {
        this.parseAndCheck("en", "en", "", "", "");
    }

    @Test
    public void testParseLanguageCountryUpperCase() {
        this.parseAndCheck("en-GB", "en", "GB", "", "");
    }

    @Test
    public void testParseLanguageCountryLowerCase() {
        this.parseAndCheck("en-gb", "en", "GB", "", "");
    }

    @Test
    public void testParseLanguageScript() {
        this.parseAndCheck("bs-Latn", "bs", "", "", "Latn");
    }

    @Test
    public void testParseLanguageScriptCountry() {
        this.parseAndCheck("bs-Latn-BA", "bs", "BA", "", "Latn");
    }

    @Test
    public void testParseLanguageCountryVariant() {
        this.parseAndCheck("ca-ES-VALENCIA", "ca", "ES", "VALENCIA", "");
    }

    @Test
    public void testParseLanguageCountryVariant2() {
        // ignore the unicode variant complexity simply down to just the trailing JP
        this.parseAndCheck("ja-JP-u-ca-japanese-x-lvariant-JP", "ja", "JP", "JP", "");
    }

    @Test
    public void testParseHeLanguage() {
        this.parseAndCheck("he", "he", "", "", "");
    }

    @Test
    public void testParseIwLanguage() {
        this.parseAndCheck("iw", "iw", "", "", "");
    }

    @Test
    public void testParseYiLanguage() {
        this.parseAndCheck("yi", "yi", "", "", "");
    }

    @Test
    public void testParseJiLanguage() {
        this.parseAndCheck("ji", "ji", "", "", "");
    }

    @Test
    public void testParseIdLanguage() {
        this.parseAndCheck("id", "id", "", "", "");
    }

    @Test
    public void testParseInLanguage() {
        this.parseAndCheck("in", "in", "", "", "");
    }

    @Test
    public void testParseUndLanguage() {
        this.parseAndCheck("und", "und", "", "", "");
    }

    @Test
    public void testParseNnNoLanguage() {
        this.parseAndCheck("nn-NO", "nn", "NO", "", "");
    }

    private void parseAndCheck(final String parse,
                               final String language,
                               final String country,
                               final String variant,
                               final String script) {
        final WalkingkookaLanguageTag wlt = WalkingkookaLanguageTag.parse(parse);

        assertEquals(language, wlt.language(), "language");
        assertEquals(script, wlt.script(), "script");
        assertEquals(country, wlt.country(), "country");
        assertEquals(variant, wlt.variant(), "variant");
    }

    // lang: no      coun: NO s:  var: NY
    @Test
    public void testWithNoNoNy() {
        final WalkingkookaLanguageTag wlt = WalkingkookaLanguageTag.with(null, "no", "NO", "NY");

        assertEquals("no", wlt.language(), "language");
        assertEquals("", wlt.script(), "script");
        assertEquals("NO", wlt.country(), "country");
        assertEquals("NY", wlt.variant(), "variant");
    }

    @Test
    public void testWithNoNoNyWithTag() {
        final WalkingkookaLanguageTag wlt = WalkingkookaLanguageTag.with("nn-NO", "no", "NO", "NY");

        assertEquals("no", wlt.language(), "language");
        assertEquals("", wlt.script(), "script");
        assertEquals("NO", wlt.country(), "country");
        assertEquals("NY", wlt.variant(), "variant");
    }

    // lookup............................................................................................................

    @Test
    public void testLookupExact() {
        this.lookupAndCheck(Maps.of("en", 1), "en", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingCountry() {
        this.lookupAndCheck(Maps.of("en", 1), "en-AU", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingCountry2() {
        this.lookupAndCheck(Maps.of("en", 1, "fr", 2), "en-AU", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingVariant() {
        this.lookupAndCheck(Maps.of("ca-ES", 1), "ca-ES-VALENCIA", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingVariant2() {
        this.lookupAndCheck(Maps.of("ca-ES", 1, "fr", 2), "ca-ES-VALENCIA", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingVariant3() {
        this.lookupAndCheck(Maps.of("ca-ES", 1, "ca", 2), "ca-ES-VALENCIA", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingVariantAndCountry() {
        this.lookupAndCheck(Maps.of("ca", 1), "ca-ES-VALENCIA", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingVariantAndCountry2() {
        this.lookupAndCheck(Maps.of("ca", 1, "fr", 2), "ca-ES-VALENCIA", 1);
    }

    @Test
    public void testLookupMatchAfterDroppingVariantAndCountryFail() {
        this.lookupAndCheck(Maps.of("en", 1), "ca-ES-VALENCIA", null);
    }

    @Test
    public void testLookupFails() {
        this.lookupAndCheck(Maps.of("en", 1), "fr", null);
    }


    private void lookupAndCheck(final Map<String, Integer> source,
                                final String tag,
                                final Integer expected) {
        assertEquals(Optional.ofNullable(expected),
                WalkingkookaLanguageTag.parse(tag).tryLookup(source::get),
                () -> "tryLookup " + tag + " with " + source);
    }

    // Object...........................................................................................................

    @Test
    public void testDifferentTag() {
        this.checkNotEquals(WalkingkookaLanguageTag.with("EN", "EN", "", ""));
    }

    @Test
    public void testDifferentLanguage() {
        this.checkNotEquals(WalkingkookaLanguageTag.with("fr-" + COUNTRY + "-" + VARIANT, "fr", COUNTRY, VARIANT));
    }

    @Test
    public void testDifferentCountry() {
        this.checkNotEquals(WalkingkookaLanguageTag.with(LANGUAGE + "-NZ-" + VARIANT, LANGUAGE, "NZ", VARIANT));
    }

    @Test
    public void testDifferentVariant() {
        this.checkNotEquals(WalkingkookaLanguageTag.with(LANGUAGE + "-" + COUNTRY + "-qld", LANGUAGE, COUNTRY, "qld"));
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        final String tag = "en-AU";
        this.toStringAndCheck(WalkingkookaLanguageTag.parse(tag), tag.replace('-', '_'));
    }

    @Test
    public void testToStringNoNoNy() {
        final String tag = "no-NO-NY";
        this.toStringAndCheck(WalkingkookaLanguageTag.parse(tag), tag.replace('-', '_'));
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<WalkingkookaLanguageTag> type() {
        return WalkingkookaLanguageTag.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }

    // HashCodeEqualsDefinedTesting2....................................................................................

    @Override
    public WalkingkookaLanguageTag createObject() {
        return WalkingkookaLanguageTag.with(TAG, LANGUAGE, COUNTRY, VARIANT);
    }
}
