/*
 * Copyright © 2020 Miroslav Pokorny
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
 */
package test;


import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Assert;
import org.junit.Test;
import walkingkooka.collect.list.Lists;
import walkingkooka.collect.set.Sets;
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;
import walkingkooka.j2cl.java.util.locale.support.LocaleSupport;
import walkingkooka.j2cl.java.util.locale.support.MultiLocaleValue;
import walkingkooka.predicate.Predicates;
import walkingkooka.text.CharSequences;

import java.io.DataOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;



@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Test
    public void testDefaultLocale() {
        final Locale defaultLocale = Locale.getDefault();
        Assert.assertEquals(Locale.forLanguageTag("EN-NZ"), defaultLocale);
        Assert.assertNotEquals(Locale.forLanguageTag("EN-AU"), defaultLocale);
    }

    @Test
    public void testAvailableLocalesAllEnglish() {
        Assert.assertEquals(Lists.empty(), Arrays.stream(Locale.getAvailableLocales())
                .filter(l -> false == l.getLanguage().startsWith("en"))
                .collect(Collectors.toList()));
    }

    @Test
    public void testAvailableLocalesZeroNonEnglish() {
        Assert.assertNotEquals(0, Locale.getAvailableLocales().length);
    }

    @Test
    public void testLocaleEn() {
        this.forLanguageTagAndCheck("EN", "en", "en");
    }

    @Test
    public void testLocaleEnAU() {
        this.forLanguageTagAndCheck("EN-AU", "en-AU", "en");
    }

    @Test
    public void testLocaleEnXYZ() {
        this.forLanguageTagAndCheck("EN-XYZ", "xyz", "xyz");
    }

    private void forLanguageTagAndCheck(final String forLanguageTag,
                                        final String expectedLanguageTag,
                                        final String expectedLanguage) {

        final java.util.Locale locale = java.util.Locale.forLanguageTag(forLanguageTag);
        Assert.assertEquals("languageTag for " + CharSequences.quoteAndEscape(forLanguageTag), expectedLanguageTag, locale.toLanguageTag());
        Assert.assertEquals("language for " + CharSequences.quoteAndEscape(forLanguageTag), expectedLanguage, locale.getLanguage());
    }

    @Test
    public void testWriteReadLocale() throws Exception {
        final String enAu = "EN-AU";

        final StringBuilder data = new StringBuilder();
        final DataOutput dataOutput = StringDataInputDataOutput.output(data::append);

        final Locale locale = Locale.forLanguageTag(enAu);
        LocaleSupport.write(locale, dataOutput);

        Assert.assertEquals(locale, LocaleSupport.read(StringDataInputDataOutput.input(data.toString())));
    }

    @Test
    public void testWriteReadLocales() throws Exception {
        final StringBuilder data = new StringBuilder();
        final DataOutput dataOutput = StringDataInputDataOutput.output(data::append);

        final Set<Locale> locales = Sets.of(Locale.forLanguageTag("en-AU"), Locale.forLanguageTag("en-NZ"));
        LocaleSupport.writeLocales(locales, dataOutput);

        Assert.assertEquals(locales, LocaleSupport.readLocales(StringDataInputDataOutput.input(data.toString())));
    }

    @Test
    public void testMultiLocaleValue() {
        Assert.assertNotNull(MultiLocaleValue.with("hello",
                Predicates.never(),
                false));
    }
}
