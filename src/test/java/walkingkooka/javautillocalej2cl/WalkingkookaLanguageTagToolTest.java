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
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;

import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class WalkingkookaLanguageTagToolTest implements PublicStaticHelperTesting<WalkingkookaLanguageTagTool> {

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
