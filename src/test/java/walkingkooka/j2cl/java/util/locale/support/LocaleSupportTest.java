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
import walkingkooka.text.Indentation;
import walkingkooka.text.LineEnding;
import walkingkooka.text.printer.Printers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public final class LocaleSupportTest implements ClassTesting2<LocaleSupport> {

    @Test
    public void testGenerateLocales() throws Exception {
        final Set<Locale> locales = Sets.of(Locale.forLanguageTag("EN-AU"), Locale.forLanguageTag("EN-NZ"), Locale.forLanguageTag("EN-US"));
        final StringBuilder comments = new StringBuilder();

        try (final ByteArrayOutputStream bytes = new ByteArrayOutputStream()) {
            LocaleSupport.generateLocales(locales,
                    new DataOutputStream(bytes),
                    "Locales123",
                    Printers.stringBuilder(comments, LineEnding.NL).indenting(Indentation.with("  ")));
        }
        assertEquals("Locales123=en-AU, en-NZ, en-US",
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

        assertEquals(locale, LocaleSupport.read(StringDataInputDataOutput.input(data.toString())));
    }

    @Test
    public void testWriteReadLocales() throws Exception {
        final StringBuilder data = new StringBuilder();
        final DataOutput dataOutput = StringDataInputDataOutput.output(data::append);

        final Set<Locale> locales = Sets.of(Locale.forLanguageTag("EN-AU"), Locale.forLanguageTag("EN-NZ"));
        LocaleSupport.writeLocales(locales, dataOutput);

        assertEquals(locales, LocaleSupport.readLocales(StringDataInputDataOutput.input(data.toString())));
    }

    @Override
    public Class<LocaleSupport> type() {
        return LocaleSupport.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
