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

import walkingkooka.javautillocalej2cl.java.util.Locale;
import walkingkooka.text.CharSequences;

import java.util.Objects;

/**
 * Represents a single language tag parsed into components. This class should not be referenced in code and is intended
 * for internal use by the javascript emulated java.util.Locale.
 */
public final class WalkingkookaLanguageTag {

    public static WalkingkookaLanguageTag parse(final String source) {
        final String language;
        String script = "";
        String country = "";
        String variant = "";
        String tag = source;

        final String[] components = source.split("-");
        final int count = components.length;
        switch (count) {
            case 0:
                language = "";
                break;
            case 1:
                language = components[0];
                break;
            default:
                language = components[0];

                final String b = components[1];
                final String c;

                switch (count) {
                    case 2:
                        c = "";
                        break;
                    default:
                        // simplified handling not perfect.
                        c = components[count - 1];
                        break;
                }

                if (false == b.isEmpty()) {
                    // false == isNumbers means ar-001 determines that the 001 is country and not script.
                    if (false == isNumbers(b) && b.equals(titleCase(b))) {
                        script = b;
                        country = c;
                    } else {
                        country = b;
                        variant = c;
                    }
                }
                break;
        }

        return with(null,
                language,
                country,
                variant,
                script);
    }

    /**
     * This is used to match Locales such as ar-001 where 001 should be interpreted as the "country".
     * Rather than hardcode a test for is this 001 we test for numbers.
     */
    private static boolean isNumbers(final String text) {
        boolean numbers = true;
        for (final char c : text.toCharArray()) {
            numbers &= Character.isDigit(c);
        }
        return numbers;
    }

    private static String titleCase(final String text) {
        return text.isEmpty() ?
                "" :
                Character.toUpperCase(text.charAt(0)) + text.substring(1).toLowerCase();
    }

    public static WalkingkookaLanguageTag with(final String tag,
                                               final String language,
                                               final String country,
                                               final String variant) {
        return with(tag,
                language,
                country,
                variant,
                "");
    }

    public static WalkingkookaLanguageTag with(final String tag,
                                               final String language,
                                               final String country,
                                               final String variant,
                                               final String script) {
        return new WalkingkookaLanguageTag(tag,
                language.toLowerCase(),
                country.toUpperCase(),
                variant,
                script);
    }

    /**
     * Trying to match the ctor ordering of the real {link java.util.Locale}.
     */
    private WalkingkookaLanguageTag(final String tag,
                                    final String language,
                                    final String country,
                                    final String variant,
                                    final String script) {
        super();

        this.language = language;
        this.country = country;
        this.script = script;
        this.variant = variant;
        this.tag = tag;
    }

    public String language() {
        return this.language;
    }

    private String language;

    public String country() {
        return this.country;
    }

    private String country;

    public String script() {
        return this.script;
    }

    private final String script;

    public String variant() {
        return this.variant;
    }

    private final String variant;

    public String toLanguageTag() {
        if (null == this.tag) {

            final String language = this.language();
            String tag = WalkingkookaLocale.languageTagFix(language);

            final String script = this.script();
            if (false == script.isEmpty()) {
                tag = tag + Locale.SEPARATOR + script;
            }

            final String country = this.country();
            if (false == CharSequences.isNullOrEmpty(country)) {
                tag = tag + Locale.SEPARATOR + country;

                final String variant = this.variant();
                if (false == CharSequences.isNullOrEmpty(variant)) {
                    tag = tag + Locale.SEPARATOR + variant;
                }
            }

            this.tag = tag;
        }
        return this.tag;
    }

    private String tag;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.country, this.language, this.variant, this.script);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof WalkingkookaLanguageTag && this.equals0((WalkingkookaLanguageTag) other);
    }

    private boolean equals0(final WalkingkookaLanguageTag other) {
        return Objects.equals(this.country, other.country) &&
                Objects.equals(this.language, other.language) &&
                Objects.equals(this.variant, other.variant) &&
                Objects.equals(this.script, other.script) &&
                Objects.equals(this.toLanguageTag(), other.toLanguageTag());
    }

    @Override
    public String toString() {
        return this.toLanguageTag().replace('-', '_');
    }
}
