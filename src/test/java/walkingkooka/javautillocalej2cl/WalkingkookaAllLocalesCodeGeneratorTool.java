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

package walkingkooka.javautillocalej2cl;

import walkingkooka.collect.list.Lists;
import walkingkooka.text.CharSequences;
import walkingkooka.text.Indentation;
import walkingkooka.text.printer.IndentingPrinter;
import walkingkooka.text.printer.Printers;

import java.util.List;
import java.util.Locale;

/**
 * This tool prints to sysout, that prints a List holding all {@link WalkingkookaLocale} with their data queried from the JDK classes.
 */
public final class WalkingkookaAllLocalesCodeGeneratorTool {

    public static void main(final String[] args) throws Exception {
        new WalkingkookaAllLocalesCodeGeneratorTool(Printers.sysOut().indenting(Indentation.with("  "))).print();
    }

    private WalkingkookaAllLocalesCodeGeneratorTool(final IndentingPrinter printer) {
        super();
        this.printer = printer;
    }

    private void print() {
        final List<Locale> locales = Lists.array();
        locales.addAll(Lists.of(Locale.getAvailableLocales()));
        locales.removeIf(l-> {
            return WalkingkookaLocale.isUnsupported(l.toLanguageTag());
        });
        locales.sort((l, r) -> l.toLanguageTag().compareTo(r.toLanguageTag()));

        // private final static java.util.List<WalkingkookaLocale> ALL = Lists.of(
        this.line("private static java.util.List<" + type(WalkingkookaLocale.class) + "> ALL = " + type(Lists.class) + ".of(");
        this.indent();
        {
            int last = locales.size() - 1;
            for (final Locale locale : locales) {
                this.line("" + type(WalkingkookaLocale.class) + ".with(");
                this.indent();
                {
                    this.line(type(WalkingkookaLanguageTag.class) + ".with(");
                    this.indent();
                    {
                        this.line(quote(locale.toLanguageTag()) + ", // languageTag");
                        this.line(quote(locale.getLanguage()) + ", // language");
                        this.line(quote(locale.getCountry()) + ", // country");
                        this.line(quote(locale.getVariant()) + ", // variant");
                        this.line(quote(locale.getScript()) + ") // script");
                    }
                    this.outdent();
                }
                this.outdent();

                this.line(")" + (--last >= 0 ? "," : ");"));
            }
        }
        this.outdent();
        this.line("");
    }

    private void indent() {
        this.printer.indent();
    }

    private void outdent() {
        this.printer.outdent();
    }

    private void line(final CharSequence text) {
        this.printer.print(text);
        this.printer.lineStart();
    }

    private final IndentingPrinter printer;

    private static CharSequence type(final Class<?> type) {
        return type.getSimpleName();
    }

    private static CharSequence quote(final String value) {
        return CharSequences.quoteAndEscape(value);
    }
}
