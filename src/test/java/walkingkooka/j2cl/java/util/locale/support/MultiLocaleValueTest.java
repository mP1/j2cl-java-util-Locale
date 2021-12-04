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
import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.predicate.PredicateTesting2;
import walkingkooka.predicate.Predicates;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;


public final class MultiLocaleValueTest implements ClassTesting2<MultiLocaleValue<String>>, PredicateTesting2<MultiLocaleValue<String>, Locale> {

    private final static String VALUE = "abc123";

    @Test
    public void testTestNullFails() {
        // ignore
    }

    @Test
    public void testTypeNaming() {
        // ignore
    }

    @Test
    public void testTrue() {
        this.testTrue(this.locale());
    }

    @Test
    public void testTrueHeIl() {
        this.testTrue(this.createPredicate(Locale.forLanguageTag("he-IL")),
                Locale.forLanguageTag("iw-IL"));
    }

    @Test
    public void testTrueIwIl() {
        this.testTrue(this.createPredicate(Locale.forLanguageTag("iw-IL")),
                Locale.forLanguageTag("he-IL"));
    }

    @Test
    public void testFalse() {
        this.testFalse(Locale.ROOT);
    }

    @Test
    public void testFindValue() {
        final Locale locale = Locale.ENGLISH;
        final String value = "FOUND2";

        final List<MultiLocaleValue<String>> multis = Lists.of(
                this.createPredicate(),
                MultiLocaleValue.with(value, Predicates.is(locale), LocaleSupport.IGNORE_NORWAY),
                MultiLocaleValue.with("never", Predicates.fake(), LocaleSupport.IGNORE_NORWAY));

        this.checkEquals(value,
                MultiLocaleValue.findValue(multis, locale));
    }

    @Override
    public MultiLocaleValue<String> createPredicate() {
        return this.createPredicate(this.locale());
    }

    private MultiLocaleValue<String> createPredicate(final Locale locale) {
        return MultiLocaleValue.with(VALUE,
                Predicate.isEqual(locale),
                LocaleSupport.IGNORE_NORWAY);
    }

    private Locale locale() {
        return Locale.forLanguageTag("EN-AU");
    }

    @Override
    public Class<MultiLocaleValue<String>> type() {
        return Cast.to(MultiLocaleValue.class);
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
