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

import walkingkooka.collect.set.Sets;
import walkingkooka.reflect.PublicStaticHelper;

import java.util.Locale;
import java.util.Set;

/**
 * This class is intended to be ignored by javascript code and only called by Locale aware generator tools.
 */
public final class WalkingkookaLanguageTagTool implements PublicStaticHelper {

    /**
     * Returns a {@link Set} containing all {@link String languageTags} including their alternate forms.
     */
    public static Set<String> all() {
        final Set<String> all = Sets.sorted();

        for(final Locale locale : Locale.getAvailableLocales()) {
            if(locale.getExtensionKeys().size() > 0) {
                continue;
            }

            final String languageTag = locale.toLanguageTag();
            all.add(languageTag);

            final String language = locale.getLanguage();
            if(language.equals("und")) {
                continue;
            }

            final String languageFixed = WalkingkookaLanguageTag.oldToNewLanguage(language);
            if(languageFixed.equals(language)) {
               continue;
            }

            if(WalkingkookaLanguageTag.isUnsupported(languageTag)) {
                continue;
            }

            final String alt = language + languageTag.substring(languageFixed.length());
            Locale.forLanguageTag(alt); // if alt is invalid this will fail.
            all.add(alt);
        }

        all.add("no-NO-NY");

        return Sets.readOnly(all);
    }

    /**
     * Stop creation
     */
    private WalkingkookaLanguageTagTool() {
        throw new UnsupportedOperationException();
    }
}
