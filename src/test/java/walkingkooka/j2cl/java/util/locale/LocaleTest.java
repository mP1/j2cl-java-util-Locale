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

package walkingkooka.j2cl.java.util.locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import walkingkooka.ToStringTesting;
import walkingkooka.collect.map.Maps;
import walkingkooka.collect.set.Sets;
import walkingkooka.j2cl.locale.WalkingkookaLanguageTag;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.ConstantsTesting;
import walkingkooka.reflect.JavaVisibility;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class LocaleTest implements ClassTesting<Locale>,
        ConstantsTesting<Locale>,
        ToStringTesting<Locale> {

    /**
     * Verify that LocaleProvider was run selecting all locales
     */
    @BeforeAll
    public static void checkLocaleProviderSelectsAllLocales() {
        assertNotNull(Locale.SEPARATOR);
        assertEquals("*", LocaleProvider.ANNOTATION_PROCESSOR_LOCALES_FILTER, "ANNOTATION_PROCESSOR_LOCALES_FILTER not set to \"*\"");
    }

    @Test
    public void testGetAvailableLocales() {
        final Map<String, java.util.Locale> allJre = Maps.sorted();
        WalkingkookaLanguageTag.locales()
                .stream()
                .filter(l -> {
                    final String language = l.getLanguage();
                    return WalkingkookaLanguageTag.oldToNewLanguage(language).equalsIgnoreCase(language);
                })
                .forEach(l -> allJre.put(l.toLanguageTag(), l));
        assertNotEquals(null, allJre.remove("nn"));
        assertNotEquals(null, allJre.remove("nn-NO"));

        final Map<String, Locale> allEmulated = Maps.sorted();
        Arrays.stream(Locale.getAvailableLocales())
                .filter(l -> {
                    final String language = l.getLanguage();
                    return WalkingkookaLanguageTag.oldToNewLanguage(language).equalsIgnoreCase(language);
                })
                .forEach(l -> allEmulated.put(l.toLanguageTag(), l));

        allEmulated.remove(""); // remove root.
        assertNotEquals(null, allEmulated.remove("nn"));
        assertNotEquals(null, allEmulated.remove("nn-NO"));

        assertEquals(allJre.keySet().stream().collect(Collectors.joining("\n")),
                allEmulated.keySet().stream().collect(Collectors.joining("\n")));

        assertEquals(allJre.size(), allEmulated.size(), "locale jre v emulated count");

        final Iterator<java.util.Locale> jreIterator = allJre.values().iterator();
        final Iterator<Locale> emulatedIterator = allEmulated.values().iterator();
        while (jreIterator.hasNext()) {
            final java.util.Locale jre = jreIterator.next();
            final Locale emulated = emulatedIterator.next();
            this.check(jre, emulated);
        }

        assertEquals(jreIterator.hasNext(), emulatedIterator.hasNext());
    }

    @Test
    public void testGetAvailableLocalesCached() {
        final Locale[] emulated = Locale.getAvailableLocales();
        final Locale[] emulated2 = Locale.getAvailableLocales();
        assertArrayEquals(emulated, emulated2);

        for (int i = 0; i < emulated.length; i++) {
            assertSame(emulated[i], emulated2[i]);
        }
    }

    @Test
    public void testDefault() {
        Locale.defaultLocale = null;

        final java.util.Locale locale = java.util.Locale.FRANCE;
        final String languageTag = locale.toLanguageTag();

        System.setProperty(Locale.DEFAULT_LOCALE, languageTag);
        assertEquals(locale.toLanguageTag(), System.getProperty(Locale.DEFAULT_LOCALE), "system property " + Locale.DEFAULT_LOCALE);
        this.check(java.util.Locale.FRANCE, Locale.forLanguageTag(languageTag));
        this.check(java.util.Locale.FRANCE, Locale.getDefault());
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
    public void testForLanguageHeIlMappedToIwIl() {
        this.forLanguageTagAndCheck("he-IL");
    }

    @Test
    public void testForLanguageIw() {
        this.forLanguageTagAndCheck("iw");
    }

    @Test
    public void testForLanguageIwIl() {
        this.forLanguageTagAndCheck("iw-IL");
    }

    @Test
    public void testForLanguageAll() {
        int i = 0;

        for(final Locale locale : Locale.getAvailableLocales()) {
            final String language = locale.getLanguage();
            if(WalkingkookaLanguageTag.oldToNewLanguage(language).equalsIgnoreCase(language)) {
                this.forLanguageTagAndCheck(locale.toLanguageTag());

                i++;
            }
        }
        assertTrue(i > 50, "Appears filter is incorrect missing too many locales");
    }

    @Test
    public void testRootConstant() {
        this.check(java.util.Locale.ROOT, Locale.ROOT);
    }

    @Test
    public void testHe() {
        this.newAndCheck("he");
    }

    @Test
    public void testHeIl() {
        this.newAndCheck("he", "il");
    }

    @Test
    public void testIw() {
        this.newAndCheck("iw");
    }

    @Test
    public void testIwIl() {
        this.newAndCheck("iw", "il");
    }

    @Test
    public void testNoNoNyLocale() {
        this.check(new java.util.Locale("no", "NO", "NY"), new Locale("no", "NO", "NY"));
    }

    @Test
    public void testAnnotationProcessorArgumentRequestedLocales() {
        Locale.setDefault(Locale.forLanguageTag(Locale.ROOT.toLanguageTag()));

        final List<String> jreLocaleTags = Arrays.stream(java.util.Locale.getAvailableLocales())
                .filter(l -> false == WalkingkookaLanguageTag.isUnsupported(l.toLanguageTag()))
                .map(java.util.Locale::toLanguageTag)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .distinct() // special case the norweign "locale" thats different but both have the same language tag.
                .collect(Collectors.toList());

        final List<String> wkTags = Arrays.stream(Locale.getAvailableLocales())
                .filter(l -> {
                    final String tag = l.toLanguageTag();
                    return java.util.Locale.forLanguageTag(tag).toLanguageTag().equals(tag);
                })
                .map(Locale::toLanguageTag)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .distinct() // removes alternate language tags
                .collect(Collectors.toList());

        assertEquals(jreLocaleTags, wkTags);
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
    }

    @Test
    public void testForLanguageTagLanguageUnknown() {
        this.forLanguageTagAndCheck("XYZ");
    }

    @Test
    public void testForLanguageTagLanguageUnknownLanguageAndUnknownCountry() {
        this.forLanguageTagAndCheck("XXX-YYY");
    }

    @Test
    public void testForLanguageTagLanguageUnknownCountry() {
        this.forLanguageTagAndCheck("EN-XYZ");
    }

    @Test
    public void testForLanguageTagLanguageUnknownCountryWithScript() {
        this.forLanguageTagAndCheck("EN-XYZ-SCRIPT");
    }

    @Test
    public void testForLanguageTagLanguageCountryUpperCase() {
        this.forLanguageTagAndCheck("EN-GB");
    }

    @Test
    public void testForLanguageTagLanguageCountryLowerCase() {
        this.forLanguageTagAndCheck("EN-gb");
    }

    @Test
    public void testForLanguageArDash001() {
        this.forLanguageTagAndCheck("ar-001");
    }

    private void forLanguageTagAndCheck(final String tag) {
        this.forLanguageTagAndCheck(tag, tag);
    }

    private void forLanguageTagAndCheck(final String tag,
                                        final String tag2) {
        // no-NO-NY Locale doesnt roundtrip.
        if (false == ("no-NO-NY".equals(tag) && tag.equals(tag2))) {
            this.check(java.util.Locale.forLanguageTag(tag),
                Locale.forLanguageTag(tag2));
        }
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
        assertEquals(language, emulated.getLanguage(), () -> "language " + emulated);
        assertEquals(country, emulated.getCountry(), () -> "country " + emulated);
        assertEquals(variant, emulated.getVariant(), () -> "variant " + emulated);
        assertEquals(script, emulated.getScript(), () -> "script " + emulated);
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
        return Sets.empty();
    }

    // ClassTesting.....................................................................................................

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
