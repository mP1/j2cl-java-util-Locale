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
import walkingkooka.collect.map.Maps;
import walkingkooka.text.CharSequences;
import walkingkooka.text.Indentation;
import walkingkooka.text.printer.IndentingPrinter;
import walkingkooka.text.printer.Printers;

import java.text.DateFormatSymbols;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

        final Map<DecimalFormatSymbols, String> decimalFormatSymbolsToMethodName = Maps.sorted(WalkingkookaAllLocalesCodeGeneratorTool::decimalFormatSymbolsComparator);

        for (final Locale locale : locales) {
            final DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

            String method = decimalFormatSymbolsToMethodName.get(symbols);
            if (null == method) {
                method = "walkingkookaDecimalFormatSymbols_" + javaMethodNameSafe(locale.toString());
                decimalFormatSymbolsToMethodName.put(symbols, method);
            }
        }

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
                        this.line(quote(locale.toLanguageTag()) + ",");
                        this.line(quote(locale.getLanguage()) + ",");
                        this.line(quote(locale.getCountry()) + ",");
                        this.line(quote(locale.getVariant()) + ",");
                        this.line(quote(locale.getScript()) + "),");
                    }
                    this.outdent();
                    this.line(decimalFormatSymbolsToMethodName.get(DecimalFormatSymbols.getInstance(locale)) + "()");
                }
                this.outdent();

                this.line(")" + (--last >= 0 ? "," : ");"));
            }
        }
        this.outdent();
        this.line("");

        // decimalFormatSymbol_ methods
        for (final Entry<DecimalFormatSymbols, String> symbolAndMethod : decimalFormatSymbolsToMethodName.entrySet()) {
            final String methodName = symbolAndMethod.getValue();
            final DecimalFormatSymbols symbols = symbolAndMethod.getKey();

            this.line("private static " + type(WalkingkookaDecimalFormatSymbols.class) + " " + methodName + "() {");
            this.indent();
            {
                this.line("return " + type(WalkingkookaDecimalFormatSymbols.class) + ".with(");
                this.indent();
                {
                    this.line(quote(symbols.getCurrency().toString()) + ",");
                    this.line(quote(symbols.getCurrencySymbol()) + ",");
                    this.line(quote(symbols.getDecimalSeparator()) + ",");
                    this.line(quote(symbols.getDigit()) + ",");
                    this.line(quote(symbols.getExponentSeparator()) + ",");
                    this.line(quote(symbols.getGroupingSeparator()) + ",");
                    this.line(quote(symbols.getInfinity()) + ",");
                    this.line(quote(symbols.getInternationalCurrencySymbol()) + ",");
                    this.line(quote(symbols.getMinusSign()) + ",");
                    this.line(quote(symbols.getMonetaryDecimalSeparator()) + ",");
                    this.line(quote(symbols.getNaN()) + ",");
                    this.line(quote(symbols.getPatternSeparator()) + ",");
                    this.line(quote(symbols.getPercent()) + ",");
                    this.line(quote(symbols.getPerMill()) + ",");
                    this.line(quote(symbols.getZeroDigit()) + ");");
                }
                this.outdent();
            }
            this.outdent();
            this.line("}");
            this.line("");
            this.line("");
        }
    }

    private static int dateFormatSymbolsComparator(final DateFormatSymbols left,
                                                   final DateFormatSymbols right) {
        return toString(left).compareTo(toString(right));
    }

    private static String toString(final DateFormatSymbols symbols) {
        return toString(symbols.getAmPmStrings()) + "," +
                toString(symbols.getEras()) + "," +
                toString(symbols.getMonths()) + "," +
                toString(symbols.getShortMonths()) + "," +
                toString(symbols.getShortWeekdays()) + "," +
                toString(symbols.getWeekdays());
    }

    private static String toString(final String[] array) {
        return Arrays.toString(array);
    }

    private static int decimalFormatSymbolsComparator(final DecimalFormatSymbols left,
                                                      final DecimalFormatSymbols right) {
        return toString(left).compareTo(toString(right));
    }

    private static String toString(final DecimalFormatSymbols symbols) {
        return symbols.getCurrency().toString() +
                symbols.getCurrencySymbol() +
                symbols.getDecimalSeparator() +
                symbols.getDigit() +
                symbols.getExponentSeparator() +
                symbols.getGroupingSeparator() +
                symbols.getInfinity() +
                symbols.getInternationalCurrencySymbol() +
                symbols.getMinusSign() +
                symbols.getMonetaryDecimalSeparator() +
                symbols.getNaN() +
                symbols.getPatternSeparator() +
                symbols.getPercent() +
                symbols.getPerMill() +
                symbols.getZeroDigit();
    }

    private static String javaMethodNameSafe(final String tag) {
        return tag.replace('-', '_').replace("#", "");
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

    private static CharSequence quote(final char value) {
        return CharSequences.quoteAndEscape(value);
    }

    private static CharSequence quote(final String value) {
        return CharSequences.quoteAndEscape(value);
    }

    private static CharSequence list(final String[] values) {
        return null == values ?
                "null" :
                Arrays.stream(values).map(WalkingkookaAllLocalesCodeGeneratorTool::quote).collect(Collectors.joining(",", "Lists.of(", ")"));
    }
}
