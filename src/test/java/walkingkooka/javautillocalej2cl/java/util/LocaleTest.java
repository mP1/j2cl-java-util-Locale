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

package walkingkooka.javautillocalej2cl.java.util;

import org.junit.jupiter.api.Test;
import walkingkooka.ToStringTesting;
import walkingkooka.collect.set.Sets;
import walkingkooka.javautillocalej2cl.WalkingkookaLocale;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.ConstantsTesting;
import walkingkooka.reflect.FieldAttributes;
import walkingkooka.reflect.JavaVisibility;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LocaleTest implements ClassTesting<Locale>,
        ConstantsTesting<Locale>,
        ToStringTesting<Locale> {

    @Test
    public void testEnglishConstant() {
        this.check(java.util.Locale.ENGLISH, Locale.ENGLISH);
    }

    @Test
    public void testEnglishUkConstant() {
        this.check(java.util.Locale.UK, Locale.UK);
    }

    @Test
    public void testEnglishUsConstant() {
        this.check(java.util.Locale.US, Locale.US);
    }

    @Test
    public void testForLanguageAz_Cyrl_AZ() {
        this.forLanguageTagAndCheck("az-Cyrl-AZ");
    }

    @Test
    public void testForLanguageca_ES_VALENCIA() {
        this.forLanguageTagAndCheck("ca-ES-VALENCIA");
    }

    @Test
    public void testForLanguageHeMappedToIw() {
        this.forLanguageTagAndCheck("he");
    }

    @Test
    public void testForLanguageIw() {
        this.forLanguageTagAndCheck("iw");
    }

    @Test
    public void testRootConstant() {
        this.check(java.util.Locale.ROOT, Locale.ROOT);
    }

    @Test
    public void testNoNoNyLocale() {
        this.check(new java.util.Locale("no", "NO", "NY"), new Locale("no", "NO", "NY"));
    }

    @Test
    public void testAllAvailableLocales() {
        Locale.setDefault(Locale.forLanguageTag(Locale.ROOT.toLanguageTag()));

        final List<String> jreLocaleTags = Arrays.stream(java.util.Locale.getAvailableLocales())
                .filter(l -> false == WalkingkookaLocale.isUnsupported(l.toLanguageTag()))
                .map(java.util.Locale::toLanguageTag)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());

        final List<String> wkTags = Arrays.stream(Locale.getAvailableLocales())
                .map(Locale::toLanguageTag)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());

        assertEquals(jreLocaleTags, wkTags);
    }

    @Test
    public void testAllConstants() throws Exception {
        for (final Field field : java.util.Locale.class.getFields()) {
            if (JavaVisibility.of(field) == JavaVisibility.PUBLIC) {
                if (FieldAttributes.get(field).contains(FieldAttributes.STATIC)) {
                    Object value = field.get(null);
                    if (value instanceof java.util.Locale) {
                        this.check((java.util.Locale) field.get(null), (Locale) Locale.class.getField(field.getName()).get(null));
                    }
                }
            }
        }
    }

    @Test
    public void testForLanguageTagUpperCase() {
        this.forLanguageTagAndCheck("EN");
    }

    @Test
    public void testForLanguageTagLowerCase() {
        this.forLanguageTagAndCheck("en");
    }

    @Test
    public void testForLanguageTagMixedCase() {
        this.forLanguageTagAndCheck("eN");
        ;
    }

    @Test
    public void testForLanguageTagLanguageUnknownCountry() {
        this.check(Locale.forLanguageTag("EN-XYZ"), "en", "XYZ", "", "");
    }

    @Test
    public void testForLanguageTagLanguageCountryUpperCase() {
        this.forLanguageTagAndCheck("EN-GB");
    }

    @Test
    public void testForLanguageTagLanguageCountryLowerCase() {
        this.forLanguageTagAndCheck("EN-gb");
    }

    private void forLanguageTagAndCheck(final String tag) {
        this.forLanguageTagAndCheck(tag, tag);
    }

    private void forLanguageTagAndCheck(final String tag, final String tag2) {
        this.check(java.util.Locale.forLanguageTag(tag), Locale.forLanguageTag(tag2));
    }

    @Test
    public void testNewLanguageUpperCase() {
        this.newAndCheck("EN");
    }

    @Test
    public void testNewLanguageLowerCase() {
        this.newAndCheck("en");
    }

    @Test
    public void testNewLanguageMixedCase() {
        this.newAndCheck("eN");
    }

    private void newAndCheck(final String language) {
        this.check(new java.util.Locale(language), new Locale(language));
    }

    @Test
    public void testNewLanguageUnknownCountry() {
        this.newAndCheck("EN", "XYZ");
    }

    @Test
    public void testNewLanguageCountry() {
        this.newAndCheck("EN", "GB");
    }

    private void newAndCheck(final String language, final String country) {
        this.check(new java.util.Locale(language, country), new Locale(language, country));
    }

    private void check(final java.util.Locale real, final Locale emulated) {
        this.check(emulated,
                real.getLanguage(),
                real.getCountry(),
                real.getVariant(),
                real.getScript());
    }

    private void check(final Locale emulated,
                       final String language,
                       final String country,
                       final String variant,
                       final String script) {
        assertEquals(language, emulated.getLanguage(), "language");
        assertEquals(country, emulated.getCountry(), "country");
        assertEquals(variant, emulated.getVariant(), "variant");
        assertEquals(script, emulated.getScript(), "script");
    }

    @Test
    public void testUnknownLanguage() {
        this.check(java.util.Locale.forLanguageTag("UNKNOWN"), "unknown", "", "", "");
    }

    @Test
    public void testUnknownCountry() {
        this.check(java.util.Locale.forLanguageTag("en-UNKNOWN"), "en", "", "UNKNOWN", "");
    }

    @Test
    public void testUnknownCountry2() {
        this.check(java.util.Locale.forLanguageTag("en-Unknown"), "en", "", "Unknown", "");
    }

    @Test
    public void testUnknownVariant() {
        this.check(java.util.Locale.forLanguageTag("en-AU-UNKnown"), "en", "AU", "UNKnown", "");
    }

    private void check(final java.util.Locale emulated,
                       final String language,
                       final String country,
                       final String variant,
                       final String script) {
        assertEquals(language, emulated.getLanguage(), "language");
        assertEquals(country, emulated.getCountry(), "country");
        assertEquals(variant, emulated.getVariant(), "variant");
        assertEquals(script, emulated.getScript(), "script");
    }

    @Test
    public void testToStringUnd() {
        this.toStringAndCheck2("XXXXX");
    }

    @Test
    public void testToStringLanguageEn() {
        this.toStringAndCheck2("en");
    }

    @Test
    public void testToStringLanguageAndCountryEnAU() {
        this.toStringAndCheck2("en-AU");
    }

    @Test
    public void testToStringScriptBsLatnBA() {
        this.toStringAndCheck2("bs-Latn-BA");
    }

    @Test
    public void testToStringLanguageCountryScriptCaESValencia() {
        this.toStringAndCheck2("ca-ES-VALENCIA");
    }

    private void toStringAndCheck2(final String languageTag) {
        this.toStringAndCheck(Locale.forLanguageTag(languageTag), java.util.Locale.forLanguageTag(languageTag).toString());
    }

    // ConstantTesting..................................................................................................

    @Override
    public Class<Locale> type() {
        return Locale.class;
    }

    @Override
    public Set<Locale> intentionalDuplicateConstants() {
        return Sets.of(Locale.CHINA, Locale.SIMPLIFIED_CHINESE);
    }

    // ClassTesting.....................................................................................................

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
