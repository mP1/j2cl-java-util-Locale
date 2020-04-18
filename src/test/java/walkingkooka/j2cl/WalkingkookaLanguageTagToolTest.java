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

import org.junit.jupiter.api.Test;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;
import walkingkooka.text.Indentation;
import walkingkooka.text.printer.Printers;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class WalkingkookaLanguageTagToolTest implements PublicStaticHelperTesting<WalkingkookaLanguageTagTool> {

    @Test
    public void testWithoutAlternatives() {
        // filter out the "duplicate" locales with two forms before comparing.
        assertEquals(Arrays.stream(Locale.getAvailableLocales())
                        .sorted(new Comparator<Locale>() {
                            public int compare(final Locale l, final Locale r) {
                                return l.toLanguageTag().compareTo(r.toLanguageTag());
                            }
                        })
                        .map(Locale::toLanguageTag)
                        .filter(t -> false == WalkingkookaLanguageTag.isUnsupported(t))
                        .sorted()
                        .distinct()
                        .collect(Collectors.joining("\n")),
                WalkingkookaLanguageTagTool.all()
                        .stream()
                        .filter(t -> {
                            final int index = t.indexOf("-");
                            final String language = -1 != index ? t.substring(0, index) : t;
                            return WalkingkookaLanguageTag.oldToNewLanguage(language).equals(language);
                        })
                        .collect(Collectors.joining("\n")));
    }

    @Test
    public void testToolOutput() {
        assertEquals(Stream.concat(Stream.of("", "in", "in-ID", "iw", "iw-IL", "ji", "ji-001"),
                Arrays.stream(Locale.getAvailableLocales())
                        .map(Locale::toLanguageTag)
                        .filter(t -> false == WalkingkookaLanguageTag.isUnsupported(t)))
                        .sorted()
                        .collect(Collectors.joining("\n")),
                Arrays.stream(WalkingkookaLanguageTagProviderTool.encode(Printers.sink().indenting(Indentation.with(""))).split(WalkingkookaLanguageTag.LOCALE_SEPARATOR))
                        .map(s -> {
                            final int slash = s.indexOf(WalkingkookaLanguageTag.LOCALE_COMPONENT_SEPARATOR);
                            return -1 == slash ? s : s.substring(0, slash);
                        })
                        .collect(Collectors.joining("\n")));
    }

    @Test
    public void testHe() {
        final Set<String> all = WalkingkookaLanguageTagTool.all();
        assertTrue(all.contains("he"), () -> "" + all);
    }

    @Test
    public void testIw() {
        final Set<String> all = WalkingkookaLanguageTagTool.all();
        assertTrue(all.contains("iw"), () -> "" + all);
    }

    @Test
    public void testEn() {
        final Set<String> all = WalkingkookaLanguageTagTool.all();
        assertTrue(all.contains("en"), () -> "" + all);
    }

    @Override
    public Class<WalkingkookaLanguageTagTool> type() {
        return WalkingkookaLanguageTagTool.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }

    @Override
    public boolean canHavePublicTypes(final Method method) {
        return true;
    }
}
