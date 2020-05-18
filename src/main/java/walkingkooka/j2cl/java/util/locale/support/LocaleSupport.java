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

import javaemul.internal.annotations.GwtIncompatible;
import walkingkooka.collect.set.Sets;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.text.printer.IndentingPrinter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public final class LocaleSupport implements PublicStaticHelper {

    public static Locale read(final DataInput data) throws IOException {
        return Locale.forLanguageTag(data.readUTF());
    }

    public static Set<Locale> readLocales(final DataInput data) throws IOException {
        final int count = data.readInt();
        final Set<Locale> locales = Sets.ordered();
        for (int i = 0; i < count; i++) {
            locales.add(read(data));
        }

        return locales;
    }

    public static void write(final Locale locale,
                             final DataOutput data) throws IOException {
        data.writeUTF(locale.toLanguageTag());
    }

    @GwtIncompatible
    public static void generateLocales(final Set<Locale> locales,
                                       final DataOutput data,
                                       final IndentingPrinter comments) throws IOException {
        comments.lineStart();
        comments.print("locales=" + locales.stream()
                .map(Locale::toLanguageTag)
                .collect(Collectors.joining(",")));

        writeLocales(locales, data);
    }

    public static void writeLocales(final Set<Locale> locales,
                                    final DataOutput data) throws IOException {
        data.writeInt(locales.size());

        for (final Locale locale : locales) {
            write(locale, data);
        }
    }

    private LocaleSupport() {
        throw new UnsupportedOperationException();
    }
}
