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

package walkingkooka.j2cl.java.util;

import org.junit.jupiter.api.Test;
import walkingkooka.collect.list.Lists;
import walkingkooka.j2cl.locale.WalkingkookaLanguageTag;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LocaleProviderTest implements ClassTesting<walkingkooka.j2cl.java.util.LocaleProvider> {

    @Test
    public void testAll() {
        final List<WalkingkookaLanguageTag> all = walkingkooka.j2cl.java.util.LocaleProvider.ALL;
        assertEquals(Lists.empty(),
                all.stream()
                        .filter(t -> false == t.language().equalsIgnoreCase("EN"))
                        .collect(Collectors.toList()),
                () -> "Expected only locales matching filter=EN-*");
    }

    @Override
    public Class<walkingkooka.j2cl.java.util.LocaleProvider> type() {
        return walkingkooka.j2cl.java.util.LocaleProvider.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
