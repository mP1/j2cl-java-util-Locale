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

import org.junit.jupiter.api.Test;
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.text.CharSequences;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class WalkingkookaLocaleTest implements ClassTesting<WalkingkookaLocale>,
        ToStringTesting<WalkingkookaLocale> {

    @Test
    public void testForLanguageTagUnknown() {
        this.forLanguageTagAndCheck("abcdef", null);
    }

    @Test
    public void testForLanguageTag() {
        final String tag = "EN";
        final WalkingkookaLocale en = WalkingkookaLocale.all()
                .stream()
                .filter(l -> l.languageTag().toLanguageTag().equals("en"))
                .findFirst().
                        orElseThrow(() -> new AssertionError("Failed to find Locale with tag " + CharSequences.quote(tag)));
        this.forLanguageTagAndCheck(tag, en);
    }

    private void forLanguageTagAndCheck(final String tag, final WalkingkookaLocale expected) {
        assertEquals(Optional.ofNullable(expected),
        WalkingkookaLocale.forLanguageTag(WalkingkookaLanguageTag.parse(tag)),
                () -> "forLanguageTag " + CharSequences.quote(tag));
    }

    @Test
    public void testEn() {
        this.checkLocale(Locale.ENGLISH);
    }

    @Test
    public void testNo_No_Ny() {
        this.checkLocale(Locale.forLanguageTag("no_NO_NY"));
    }

    @Test
    public void testAllLocales() {
        for (final Locale locale : Locale.getAvailableLocales()) {
            final String languageTag = locale.toLanguageTag();
            if(WalkingkookaLocale.isUnsupported(languageTag)) {
                continue;
            }

            switch(languageTag) {
                case "no-NO-NY":
                case "nn-NO":
                case "und":
                    break;
                default:
                    this.checkLocale(locale);
            }
        }
    }

    private void checkLocale(final Locale locale) {
        final WalkingkookaLanguageTag tag = WalkingkookaLanguageTag.parse(locale.toLanguageTag());
        this.checkLocale(WalkingkookaLocale.all()
        .stream()
        .filter(l -> l.languageTag().toLanguageTag().equalsIgnoreCase(tag.toLanguageTag()))
        .findFirst()
        .orElseThrow(() -> new AssertionError("Unable to find locale " + locale.toLanguageTag())),
         locale);
    }

    private void checkLocale(final WalkingkookaLocale locale,
                             final Locale jreLocale) {
        this.checkLanguageTag(locale.languageTag(), jreLocale);
    }

    private void checkLanguageTag(final WalkingkookaLanguageTag tag,
                                  final Locale locale) {
        assertEquals(locale.getLanguage(), tag.language(), () -> "language " + locale.toLanguageTag() + " " + locale);
        assertEquals(locale.getCountry(), tag.country(), () -> "country " + locale.toLanguageTag() + " " + locale);
        assertEquals(locale.getVariant(), tag.variant(), () -> "variant " +locale.toLanguageTag() + " " + locale);
        assertEquals(locale.getScript(), tag.script(), () -> "script " +locale.toLanguageTag() + " " + locale);
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        final String tag = "en-AU";
        this.toStringAndCheck(WalkingkookaLocale.forLanguageTag(WalkingkookaLanguageTag.parse(tag)).get(),
                tag.replace('-', '_'));
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<WalkingkookaLocale> type() {
        return WalkingkookaLocale.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
