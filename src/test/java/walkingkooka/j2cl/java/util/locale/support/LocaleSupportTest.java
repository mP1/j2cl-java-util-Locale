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

package walkingkooka.j2cl.java.util.locale.support;

import org.junit.jupiter.api.Test;
import walkingkooka.collect.set.Sets;
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.text.CharSequences;
import walkingkooka.text.Indentation;
import walkingkooka.text.LineEnding;
import walkingkooka.text.printer.Printers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;


public final class LocaleSupportTest implements ClassTesting2<LocaleSupport> {

    @Test
    public void testGenerateLocales() throws Exception {
        final Set<Locale> locales = Sets.of(Locale.forLanguageTag("EN-AU"), Locale.forLanguageTag("EN-NZ"), Locale.forLanguageTag("EN-US"));
        final StringBuilder comments = new StringBuilder();

        try (final ByteArrayOutputStream bytes = new ByteArrayOutputStream()) {
            LocaleSupport.generateLocales(locales,
                    new DataOutputStream(bytes),
                    "Locales123",
                    Printers.stringBuilder(comments, LineEnding.NL).indenting(Indentation.SPACES2));
        }
        this.checkEquals("Locales123=en-AU, en-NZ, en-US",
                comments.toString(),
                () -> " generateLocales " + locales);
    }

    @Test
    public void testWriteReadLocale() throws Exception {
        final String enAu = "EN-AU";

        final StringBuilder data = new StringBuilder();
        final DataOutput dataOutput = StringDataInputDataOutput.output(data::append);

        final Locale locale = Locale.forLanguageTag(enAu);
        LocaleSupport.write(locale, dataOutput);

        this.checkEquals(locale, LocaleSupport.read(StringDataInputDataOutput.input(data.toString())));
    }

    @Test
    public void testWriteReadLocales() throws Exception {
        final StringBuilder data = new StringBuilder();
        final DataOutput dataOutput = StringDataInputDataOutput.output(data::append);

        final Set<Locale> locales = Sets.of(Locale.forLanguageTag("EN-AU"), Locale.forLanguageTag("EN-NZ"));
        LocaleSupport.writeLocales(locales, dataOutput);

        this.checkEquals(locales, LocaleSupport.readLocales(StringDataInputDataOutput.input(data.toString())));
    }

    // alternatives.....................................................................................................

    @Test
    public void testAlternativesWithout() {
        this.alternativesAndCheck("EN", null);
    }

    @Test
    public void testAlternativesWithout2() {
        this.alternativesAndCheck("FR", null);
    }

    @Test
    public void testAlternativesHe() {
        this.alternativesAndCheck("he", "iw");
    }

    @Test
    public void testAlternativesHeIl() {
        this.alternativesAndCheck("he-il", "iw-il");
    }

    @Test
    public void testAlternativesIW() {
        this.alternativesAndCheck("iw", "he");
    }

    @Test
    public void testAlternativesIncludeNorwayNN_NO() {
        this.alternativesAndCheck(nnNo(),
                LocaleSupport.INCLUDE_NORWAY,
                Locale.forLanguageTag("no-NO"));
    }

    @Test
    public void testAlternativesIgnoreNorwayNN_NO() {
        this.alternativesAndCheck(nnNo(),
                LocaleSupport.IGNORE_NORWAY,
                null);
    }

    @Test
    public void testAlternativesIncludeNorwayNO_NO_NY() {
        this.alternativesAndCheck(noNoNy(),
                LocaleSupport.INCLUDE_NORWAY,
                nnNo());
    }

    @Test
    public void testAlternativesIgnoreNorwayNO_NO_NY() {
        this.alternativesAndCheck(noNoNy(),
                LocaleSupport.IGNORE_NORWAY,
                null);
    }

    private Locale nnNo() {
        return Locale.forLanguageTag("nn-NO");
    }

    private Locale noNoNy() {
        return Arrays.stream(Locale.getAvailableLocales())
                .filter(l -> l.toString().equalsIgnoreCase("no_NO_NY"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Failed to \"no-NO-NY\""));
    }

    private void alternativesAndCheck(final String locale,
                                      final String alternative) {
        alternativesAndCheck(locale,
                LocaleSupport.IGNORE_NORWAY,
                alternative);
    }

    private void alternativesAndCheck(final String locale,
                                      final boolean includeNorway,
                                      final String alternative) {
        alternativesAndCheck(Locale.forLanguageTag(locale),
                includeNorway,
                null == alternative ? null : Locale.forLanguageTag(alternative));
    }

    private void alternativesAndCheck(final Locale locale,
                                      final boolean includeNorway,
                                      final Locale alternative) {
        this.checkEquals(Optional.ofNullable(alternative),
                LocaleSupport.alternatives(locale, includeNorway),
                () -> "alternative for " + CharSequences.quoteIfChars(locale.toString()));
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<LocaleSupport> type() {
        return LocaleSupport.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
