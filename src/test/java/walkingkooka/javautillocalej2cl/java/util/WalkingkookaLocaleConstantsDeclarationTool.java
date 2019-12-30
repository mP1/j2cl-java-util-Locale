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

package walkingkooka.javautillocalej2cl.java.util;

import walkingkooka.collect.map.Maps;
import walkingkooka.reflect.FieldAttributes;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.text.CharSequences;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This tool prints to sysout, json that holds all {@link java.util.Locale locales}. This can be used to initialize
 * {@link Locale}.
 */
public final class WalkingkookaLocaleConstantsDeclarationTool {

    public static void main(final String[] args) throws Exception {
        final Map<String, java.util.Locale> constantToLocale = Maps.sorted();

        for (final Field field : java.util.Locale.class.getFields()) {
            if (JavaVisibility.of(field) == JavaVisibility.PUBLIC) {
                if (FieldAttributes.get(field).contains(FieldAttributes.STATIC)) {
                    Object value = field.get(null);
                    if (value instanceof java.util.Locale) {
                        constantToLocale.put(field.getName(), (java.util.Locale) value);
                    }
                }
            }
        }

        for (final Entry<String, java.util.Locale> constantAndLocale : constantToLocale.entrySet()) {
            final String name = constantAndLocale.getKey();
            final java.util.Locale locale = constantAndLocale.getValue();

            CharSequence tag = quote(locale.getLanguage());

            final String country = locale.getCountry();
            if (false == CharSequences.isNullOrEmpty(country)) {
                tag = tag + ", " + quote(country);

                final String variant = locale.getVariant();
                if (false == CharSequences.isNullOrEmpty(variant)) {
                    tag = tag + ", " + quote(variant);
                }
            }

            System.out.println("public final static Locale " + name + " = defineConstant(" + tag + ");");
        }
    }

    private static CharSequence quote(final String text) {
        return null == text ?
                "" :
                CharSequences.quoteAndEscape(text);
    }
}
