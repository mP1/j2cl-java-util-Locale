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

import walkingkooka.ToStringBuilder;

/**
 * A record that should only be used to populate the JRE emulated java.text.DecimalFormatSymbols
 */
public final class WalkingkookaDecimalFormatSymbols {

    static WalkingkookaDecimalFormatSymbols with(final String currency,
                                                 final String currencySymbol,
                                                 final char decimalSeparator,
                                                 final char digit,
                                                 final String exponentSeparator,
                                                 final char groupingSeparator,
                                                 final String infinity,
                                                 final String internationalCurrencySymbol,
                                                 final char minusSign,
                                                 final char monetaryDecimalSeparator,
                                                 final String nan,
                                                 final char patternSeparator,
                                                 final char percent,
                                                 final char perMill,
                                                 final char zeroDigit) {
        return new WalkingkookaDecimalFormatSymbols(currency,
                currencySymbol,
                decimalSeparator,
                digit,
                exponentSeparator,
                groupingSeparator,
                infinity,
                internationalCurrencySymbol,
                minusSign,
                monetaryDecimalSeparator,
                nan,
                patternSeparator,
                percent,
                perMill,
                zeroDigit);
    }

    private WalkingkookaDecimalFormatSymbols(final String currency,
                                             final String currencySymbol,
                                             final char decimalSeparator,
                                             final char digit,
                                             final String exponentSeparator,
                                             final char groupingSeparator,
                                             final String infinity,
                                             final String internationalCurrencySymbol,
                                             final char minusSign,
                                             final char monetaryDecimalSeparator,
                                             final String nan,
                                             final char patternSeparator,
                                             final char percent,
                                             final char perMill,
                                             final char zeroDigit) {
        super();
        this.currency = currency;
        this.currencySymbol = currencySymbol;
        this.decimalSeparator = decimalSeparator;
        this.digit = digit;
        this.exponentSeparator = exponentSeparator;
        this.groupingSeparator = groupingSeparator;
        this.infinity = infinity;
        this.internationalCurrencySymbol = internationalCurrencySymbol;
        this.minusSign = minusSign;
        this.monetaryDecimalSeparator = monetaryDecimalSeparator;
        this.nan = nan;
        this.patternSeparator = patternSeparator;
        this.percent = percent;
        this.perMill = perMill;
        this.zeroDigit = zeroDigit;
    }

    public String currency() {
        return this.currency;
    }

    private final String currency;

    public String currencySymbol() {
        return this.currencySymbol;
    }

    private final String currencySymbol;

    public char decimalSeparator() {
        return this.decimalSeparator;
    }

    private final char decimalSeparator;

    public char digit() {
        return this.digit;
    }

    private final char digit;

    public String exponentSeparator() {
        return this.exponentSeparator;
    }

    private final String exponentSeparator;

    public char groupingSeparator() {
        return this.groupingSeparator;
    }

    private final char groupingSeparator;

    public String infinity() {
        return this.infinity;
    }

    private final String infinity;

    public String internationalCurrencySymbol() {
        return this.internationalCurrencySymbol;
    }

    private final String internationalCurrencySymbol;

    public char minusSign() {
        return this.minusSign;
    }

    private final char minusSign;

    public char monetaryDecimalSeparator() {
        return this.monetaryDecimalSeparator;
    }

    private final char monetaryDecimalSeparator;

    public String nan() {
        return this.nan;
    }

    private final String nan;

    public char patternSeparator() {
        return this.patternSeparator;
    }

    private final char patternSeparator;

    public char percent() {
        return this.percent;
    }

    private final char percent;

    public char perMill() {
        return this.perMill;
    }

    private final char perMill;

    public char zeroDigit() {
        return this.zeroDigit;
    }

    private final char zeroDigit;

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("currency").value(this.currency())
                .label("currencySymbol").value(this.currencySymbol())
                .label("decimalSeparator").value(this.decimalSeparator())
                .label("digit").value(this.digit())
                .label("exponentSeparator").value(this.exponentSeparator())
                .label("groupingSeparator").value(this.groupingSeparator())
                .label("infinity").value(this.infinity())
                .label("internationalCurrencySymbol").value(this.internationalCurrencySymbol())
                .label("minusSign").value(this.minusSign())
                .label("monetaryDecimalSeparator").value(this.monetaryDecimalSeparator())
                .label("nan").value(this.nan())
                .label("patternSeparator").value(this.patternSeparator())
                .label("percent").value(this.percent())
                .label("perMill").value(this.perMill())
                .label("zeroDigit").value(this.zeroDigit())
                .build();
    }
}
