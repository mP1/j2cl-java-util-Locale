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

package walkingkooka.j2cl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.util.SystemProperty;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class WalkingkookaLocaleTest implements ClassTesting<WalkingkookaLocale>,
        ToStringTesting<WalkingkookaLocale> {

    @BeforeAll
    public static void beforeJre9Check() {
        final String version = SystemProperty.JAVA_VERSION.requiredPropertyValue();
        final String[] versionComponents = version.split("\\.");
        final int majorVersion = Integer.parseInt(versionComponents[0]);
        assertEquals(9, majorVersion, () -> "Tests assume JRE 9.0 because it makes assumptions based on the number Locales provided with that, version=" + version);
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
            if(WalkingkookaLanguageTag.isUnsupported(languageTag)) {
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
        .filter(l -> l.languageTag.toLanguageTag().equalsIgnoreCase(tag.toLanguageTag()))
        .findFirst()
        .orElseThrow(() -> new AssertionError("Unable to find locale " + locale.toLanguageTag())),
         locale);
    }

    private void checkLocale(final WalkingkookaLocale locale,
                             final Locale jreLocale) {
        this.checkLanguageTag(locale.languageTag, jreLocale);
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
        final WalkingkookaLanguageTag tag = WalkingkookaLanguageTag.parse("en-AU");

        final WalkingkookaLocale locale = WalkingkookaLocale.all()
                .stream()
                .filter(l -> l.languageTag.equals(tag))
                .findFirst()
                .get();

        this.toStringAndCheck(locale, tag.toString().replace('-', '_'));
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
