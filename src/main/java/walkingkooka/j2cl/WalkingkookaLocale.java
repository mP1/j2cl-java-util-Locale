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

import walkingkooka.ToStringBuilder;
import walkingkooka.collect.list.Lists;

import java.util.Optional;

public final class WalkingkookaLocale {

    /**
     * Complex locales that are ignored.
     */
    public static boolean isUnsupported(final String languageTag) {
        boolean ignored;

        switch (languageTag) {
            case "ja-JP-u-ca-japanese-x-lvariant-JP":
            case "th-TH-u-nu-thai-x-lvariant-TH":
                ignored = true;
                break;
            default:
                ignored = false;
                break;
        }

        return ignored;
    }

    /**
     * Makes the language lower case and substitutes new language codes with old to match JRE behaviour.
     */
    public static String languageFix(final String language) {
        final String lower = language.toLowerCase();

        final String fixed;

        switch (lower) {
            case "he":
                fixed = "iw";
                break;
            case "yi":
                fixed = "ji";
                break;
            case "id":
                fixed = "in";
                break;
            case "und":
                fixed = "";
                break;
            default:
                fixed = lower.toLowerCase();
                break;
        }
        return fixed;
    }

    /**
     * The inverse of {@link #languageFix(String).}
     */
    public static String languageTagFix(final String language) {
        final String lower = language.toLowerCase();

        final String fixed;

        switch (lower) {
            case "iw":
                fixed = "he";
                break;
            case "ji":
                fixed = "yi";
                break;
            case "in":
                fixed = "id";
                break;
            case "":
                fixed = "und";
                break;
            default:
                fixed = lower.toLowerCase();
                break;
        }

        return fixed;
    }

    /**
     * Finds the matching {@link WalkingkookaLocale} for the given {@link WalkingkookaLanguageTag}.
     */
    public static Optional<WalkingkookaLocale> forLanguageTag(final WalkingkookaLanguageTag tag) {
        return all()
            .stream()
            .filter(l -> l.test(tag))
            .findFirst();
    }

    /**
     * Returns all {@link WalkingkookaLocale locales} known to the system.
     */
    public static java.util.List<WalkingkookaLocale> all() {
        return ALL;
    }

    private static java.util.List<WalkingkookaLocale> ALL = Lists.of(
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "", // languageTag
                            "", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "af", // languageTag
                            "af", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "af-NA", // languageTag
                            "af", // language
                            "NA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "af-ZA", // languageTag
                            "af", // language
                            "ZA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "agq", // languageTag
                            "agq", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "agq-CM", // languageTag
                            "agq", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ak", // languageTag
                            "ak", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ak-GH", // languageTag
                            "ak", // language
                            "GH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "am", // languageTag
                            "am", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "am-ET", // languageTag
                            "am", // language
                            "ET", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar", // languageTag
                            "ar", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-001", // languageTag
                            "ar", // language
                            "001", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-AE", // languageTag
                            "ar", // language
                            "AE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-BH", // languageTag
                            "ar", // language
                            "BH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-DJ", // languageTag
                            "ar", // language
                            "DJ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-DZ", // languageTag
                            "ar", // language
                            "DZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-EG", // languageTag
                            "ar", // language
                            "EG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-EH", // languageTag
                            "ar", // language
                            "EH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-ER", // languageTag
                            "ar", // language
                            "ER", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-IL", // languageTag
                            "ar", // language
                            "IL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-IQ", // languageTag
                            "ar", // language
                            "IQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-JO", // languageTag
                            "ar", // language
                            "JO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-KM", // languageTag
                            "ar", // language
                            "KM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-KW", // languageTag
                            "ar", // language
                            "KW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-LB", // languageTag
                            "ar", // language
                            "LB", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-LY", // languageTag
                            "ar", // language
                            "LY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-MA", // languageTag
                            "ar", // language
                            "MA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-MR", // languageTag
                            "ar", // language
                            "MR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-OM", // languageTag
                            "ar", // language
                            "OM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-PS", // languageTag
                            "ar", // language
                            "PS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-QA", // languageTag
                            "ar", // language
                            "QA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-SA", // languageTag
                            "ar", // language
                            "SA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-SD", // languageTag
                            "ar", // language
                            "SD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-SO", // languageTag
                            "ar", // language
                            "SO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-SS", // languageTag
                            "ar", // language
                            "SS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-SY", // languageTag
                            "ar", // language
                            "SY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-TD", // languageTag
                            "ar", // language
                            "TD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-TN", // languageTag
                            "ar", // language
                            "TN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ar-YE", // languageTag
                            "ar", // language
                            "YE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "as", // languageTag
                            "as", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "as-IN", // languageTag
                            "as", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "asa", // languageTag
                            "asa", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "asa-TZ", // languageTag
                            "asa", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ast", // languageTag
                            "ast", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ast-ES", // languageTag
                            "ast", // language
                            "ES", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "az", // languageTag
                            "az", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "az-AZ", // languageTag
                            "az", // language
                            "AZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "az-Cyrl", // languageTag
                            "az", // language
                            "", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "az-Cyrl-AZ", // languageTag
                            "az", // language
                            "AZ", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "az-Latn", // languageTag
                            "az", // language
                            "", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "az-Latn-AZ", // languageTag
                            "az", // language
                            "AZ", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bas", // languageTag
                            "bas", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bas-CM", // languageTag
                            "bas", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "be", // languageTag
                            "be", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "be-BY", // languageTag
                            "be", // language
                            "BY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bem", // languageTag
                            "bem", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bem-ZM", // languageTag
                            "bem", // language
                            "ZM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bez", // languageTag
                            "bez", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bez-TZ", // languageTag
                            "bez", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bg", // languageTag
                            "bg", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bg-BG", // languageTag
                            "bg", // language
                            "BG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bm", // languageTag
                            "bm", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bm-ML", // languageTag
                            "bm", // language
                            "ML", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bn", // languageTag
                            "bn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bn-BD", // languageTag
                            "bn", // language
                            "BD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bn-IN", // languageTag
                            "bn", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bo", // languageTag
                            "bo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bo-CN", // languageTag
                            "bo", // language
                            "CN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bo-IN", // languageTag
                            "bo", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "br", // languageTag
                            "br", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "br-FR", // languageTag
                            "br", // language
                            "FR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "brx", // languageTag
                            "brx", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "brx-IN", // languageTag
                            "brx", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bs", // languageTag
                            "bs", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bs-BA", // languageTag
                            "bs", // language
                            "BA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bs-Cyrl", // languageTag
                            "bs", // language
                            "", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bs-Cyrl-BA", // languageTag
                            "bs", // language
                            "BA", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bs-Latn", // languageTag
                            "bs", // language
                            "", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "bs-Latn-BA", // languageTag
                            "bs", // language
                            "BA", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ca", // languageTag
                            "ca", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ca-AD", // languageTag
                            "ca", // language
                            "AD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ca-ES", // languageTag
                            "ca", // language
                            "ES", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ca-ES-VALENCIA", // languageTag
                            "ca", // language
                            "ES", // country
                            "VALENCIA", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ca-FR", // languageTag
                            "ca", // language
                            "FR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ca-IT", // languageTag
                            "ca", // language
                            "IT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ce", // languageTag
                            "ce", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ce-RU", // languageTag
                            "ce", // language
                            "RU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cgg", // languageTag
                            "cgg", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cgg-UG", // languageTag
                            "cgg", // language
                            "UG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "chr", // languageTag
                            "chr", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "chr-US", // languageTag
                            "chr", // language
                            "US", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ckb", // languageTag
                            "ckb", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ckb-IQ", // languageTag
                            "ckb", // language
                            "IQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ckb-IR", // languageTag
                            "ckb", // language
                            "IR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cs", // languageTag
                            "cs", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cs-CZ", // languageTag
                            "cs", // language
                            "CZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cu", // languageTag
                            "cu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cu-RU", // languageTag
                            "cu", // language
                            "RU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cy", // languageTag
                            "cy", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "cy-GB", // languageTag
                            "cy", // language
                            "GB", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "da", // languageTag
                            "da", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "da-DK", // languageTag
                            "da", // language
                            "DK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "da-GL", // languageTag
                            "da", // language
                            "GL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dav", // languageTag
                            "dav", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dav-KE", // languageTag
                            "dav", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "de", // languageTag
                            "de", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "de-AT", // languageTag
                            "de", // language
                            "AT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "de-BE", // languageTag
                            "de", // language
                            "BE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "de-CH", // languageTag
                            "de", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "de-DE", // languageTag
                            "de", // language
                            "DE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "de-LI", // languageTag
                            "de", // language
                            "LI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "de-LU", // languageTag
                            "de", // language
                            "LU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dje", // languageTag
                            "dje", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dje-NE", // languageTag
                            "dje", // language
                            "NE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dsb", // languageTag
                            "dsb", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dsb-DE", // languageTag
                            "dsb", // language
                            "DE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dua", // languageTag
                            "dua", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dua-CM", // languageTag
                            "dua", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dyo", // languageTag
                            "dyo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dyo-SN", // languageTag
                            "dyo", // language
                            "SN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dz", // languageTag
                            "dz", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "dz-BT", // languageTag
                            "dz", // language
                            "BT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ebu", // languageTag
                            "ebu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ebu-KE", // languageTag
                            "ebu", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ee", // languageTag
                            "ee", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ee-GH", // languageTag
                            "ee", // language
                            "GH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ee-TG", // languageTag
                            "ee", // language
                            "TG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "el", // languageTag
                            "el", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "el-CY", // languageTag
                            "el", // language
                            "CY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "el-GR", // languageTag
                            "el", // language
                            "GR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en", // languageTag
                            "en", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-001", // languageTag
                            "en", // language
                            "001", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-150", // languageTag
                            "en", // language
                            "150", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-AG", // languageTag
                            "en", // language
                            "AG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-AI", // languageTag
                            "en", // language
                            "AI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-AS", // languageTag
                            "en", // language
                            "AS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-AT", // languageTag
                            "en", // language
                            "AT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-AU", // languageTag
                            "en", // language
                            "AU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-BB", // languageTag
                            "en", // language
                            "BB", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-BE", // languageTag
                            "en", // language
                            "BE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-BI", // languageTag
                            "en", // language
                            "BI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-BM", // languageTag
                            "en", // language
                            "BM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-BS", // languageTag
                            "en", // language
                            "BS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-BW", // languageTag
                            "en", // language
                            "BW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-BZ", // languageTag
                            "en", // language
                            "BZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-CA", // languageTag
                            "en", // language
                            "CA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-CC", // languageTag
                            "en", // language
                            "CC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-CH", // languageTag
                            "en", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-CK", // languageTag
                            "en", // language
                            "CK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-CM", // languageTag
                            "en", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-CX", // languageTag
                            "en", // language
                            "CX", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-CY", // languageTag
                            "en", // language
                            "CY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-DE", // languageTag
                            "en", // language
                            "DE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-DG", // languageTag
                            "en", // language
                            "DG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-DK", // languageTag
                            "en", // language
                            "DK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-DM", // languageTag
                            "en", // language
                            "DM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-ER", // languageTag
                            "en", // language
                            "ER", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-FI", // languageTag
                            "en", // language
                            "FI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-FJ", // languageTag
                            "en", // language
                            "FJ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-FK", // languageTag
                            "en", // language
                            "FK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-FM", // languageTag
                            "en", // language
                            "FM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GB", // languageTag
                            "en", // language
                            "GB", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GD", // languageTag
                            "en", // language
                            "GD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GG", // languageTag
                            "en", // language
                            "GG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GH", // languageTag
                            "en", // language
                            "GH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GI", // languageTag
                            "en", // language
                            "GI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GM", // languageTag
                            "en", // language
                            "GM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GU", // languageTag
                            "en", // language
                            "GU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-GY", // languageTag
                            "en", // language
                            "GY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-HK", // languageTag
                            "en", // language
                            "HK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-IE", // languageTag
                            "en", // language
                            "IE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-IL", // languageTag
                            "en", // language
                            "IL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-IM", // languageTag
                            "en", // language
                            "IM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-IN", // languageTag
                            "en", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-IO", // languageTag
                            "en", // language
                            "IO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-JE", // languageTag
                            "en", // language
                            "JE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-JM", // languageTag
                            "en", // language
                            "JM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-KE", // languageTag
                            "en", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-KI", // languageTag
                            "en", // language
                            "KI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-KN", // languageTag
                            "en", // language
                            "KN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-KY", // languageTag
                            "en", // language
                            "KY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-LC", // languageTag
                            "en", // language
                            "LC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-LR", // languageTag
                            "en", // language
                            "LR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-LS", // languageTag
                            "en", // language
                            "LS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MG", // languageTag
                            "en", // language
                            "MG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MH", // languageTag
                            "en", // language
                            "MH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MO", // languageTag
                            "en", // language
                            "MO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MP", // languageTag
                            "en", // language
                            "MP", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MS", // languageTag
                            "en", // language
                            "MS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MT", // languageTag
                            "en", // language
                            "MT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MU", // languageTag
                            "en", // language
                            "MU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MW", // languageTag
                            "en", // language
                            "MW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-MY", // languageTag
                            "en", // language
                            "MY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-NA", // languageTag
                            "en", // language
                            "NA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-NF", // languageTag
                            "en", // language
                            "NF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-NG", // languageTag
                            "en", // language
                            "NG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-NL", // languageTag
                            "en", // language
                            "NL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-NR", // languageTag
                            "en", // language
                            "NR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-NU", // languageTag
                            "en", // language
                            "NU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-NZ", // languageTag
                            "en", // language
                            "NZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-PG", // languageTag
                            "en", // language
                            "PG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-PH", // languageTag
                            "en", // language
                            "PH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-PK", // languageTag
                            "en", // language
                            "PK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-PN", // languageTag
                            "en", // language
                            "PN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-PR", // languageTag
                            "en", // language
                            "PR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-PW", // languageTag
                            "en", // language
                            "PW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-RW", // languageTag
                            "en", // language
                            "RW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SB", // languageTag
                            "en", // language
                            "SB", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SC", // languageTag
                            "en", // language
                            "SC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SD", // languageTag
                            "en", // language
                            "SD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SE", // languageTag
                            "en", // language
                            "SE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SG", // languageTag
                            "en", // language
                            "SG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SH", // languageTag
                            "en", // language
                            "SH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SI", // languageTag
                            "en", // language
                            "SI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SL", // languageTag
                            "en", // language
                            "SL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SS", // languageTag
                            "en", // language
                            "SS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SX", // languageTag
                            "en", // language
                            "SX", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-SZ", // languageTag
                            "en", // language
                            "SZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-TC", // languageTag
                            "en", // language
                            "TC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-TK", // languageTag
                            "en", // language
                            "TK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-TO", // languageTag
                            "en", // language
                            "TO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-TT", // languageTag
                            "en", // language
                            "TT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-TV", // languageTag
                            "en", // language
                            "TV", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-TZ", // languageTag
                            "en", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-UG", // languageTag
                            "en", // language
                            "UG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-UM", // languageTag
                            "en", // language
                            "UM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-US", // languageTag
                            "en", // language
                            "US", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-US-POSIX", // languageTag
                            "en", // language
                            "US", // country
                            "POSIX", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-VC", // languageTag
                            "en", // language
                            "VC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-VG", // languageTag
                            "en", // language
                            "VG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-VI", // languageTag
                            "en", // language
                            "VI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-VU", // languageTag
                            "en", // language
                            "VU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-WS", // languageTag
                            "en", // language
                            "WS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-ZA", // languageTag
                            "en", // language
                            "ZA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-ZM", // languageTag
                            "en", // language
                            "ZM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "en-ZW", // languageTag
                            "en", // language
                            "ZW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "eo", // languageTag
                            "eo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "eo-001", // languageTag
                            "eo", // language
                            "001", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es", // languageTag
                            "es", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-419", // languageTag
                            "es", // language
                            "419", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-AR", // languageTag
                            "es", // language
                            "AR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-BO", // languageTag
                            "es", // language
                            "BO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-BR", // languageTag
                            "es", // language
                            "BR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-CL", // languageTag
                            "es", // language
                            "CL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-CO", // languageTag
                            "es", // language
                            "CO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-CR", // languageTag
                            "es", // language
                            "CR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-CU", // languageTag
                            "es", // language
                            "CU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-DO", // languageTag
                            "es", // language
                            "DO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-EA", // languageTag
                            "es", // language
                            "EA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-EC", // languageTag
                            "es", // language
                            "EC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-ES", // languageTag
                            "es", // language
                            "ES", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-GQ", // languageTag
                            "es", // language
                            "GQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-GT", // languageTag
                            "es", // language
                            "GT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-HN", // languageTag
                            "es", // language
                            "HN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-IC", // languageTag
                            "es", // language
                            "IC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-MX", // languageTag
                            "es", // language
                            "MX", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-NI", // languageTag
                            "es", // language
                            "NI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-PA", // languageTag
                            "es", // language
                            "PA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-PE", // languageTag
                            "es", // language
                            "PE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-PH", // languageTag
                            "es", // language
                            "PH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-PR", // languageTag
                            "es", // language
                            "PR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-PY", // languageTag
                            "es", // language
                            "PY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-SV", // languageTag
                            "es", // language
                            "SV", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-US", // languageTag
                            "es", // language
                            "US", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-UY", // languageTag
                            "es", // language
                            "UY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "es-VE", // languageTag
                            "es", // language
                            "VE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "et", // languageTag
                            "et", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "et-EE", // languageTag
                            "et", // language
                            "EE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "eu", // languageTag
                            "eu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "eu-ES", // languageTag
                            "eu", // language
                            "ES", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ewo", // languageTag
                            "ewo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ewo-CM", // languageTag
                            "ewo", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fa", // languageTag
                            "fa", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fa-AF", // languageTag
                            "fa", // language
                            "AF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fa-IR", // languageTag
                            "fa", // language
                            "IR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ff", // languageTag
                            "ff", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ff-CM", // languageTag
                            "ff", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ff-GN", // languageTag
                            "ff", // language
                            "GN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ff-MR", // languageTag
                            "ff", // language
                            "MR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ff-SN", // languageTag
                            "ff", // language
                            "SN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fi", // languageTag
                            "fi", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fi-FI", // languageTag
                            "fi", // language
                            "FI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fil", // languageTag
                            "fil", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fil-PH", // languageTag
                            "fil", // language
                            "PH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fo", // languageTag
                            "fo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fo-DK", // languageTag
                            "fo", // language
                            "DK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fo-FO", // languageTag
                            "fo", // language
                            "FO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr", // languageTag
                            "fr", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-BE", // languageTag
                            "fr", // language
                            "BE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-BF", // languageTag
                            "fr", // language
                            "BF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-BI", // languageTag
                            "fr", // language
                            "BI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-BJ", // languageTag
                            "fr", // language
                            "BJ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-BL", // languageTag
                            "fr", // language
                            "BL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-CA", // languageTag
                            "fr", // language
                            "CA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-CD", // languageTag
                            "fr", // language
                            "CD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-CF", // languageTag
                            "fr", // language
                            "CF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-CG", // languageTag
                            "fr", // language
                            "CG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-CH", // languageTag
                            "fr", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-CI", // languageTag
                            "fr", // language
                            "CI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-CM", // languageTag
                            "fr", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-DJ", // languageTag
                            "fr", // language
                            "DJ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-DZ", // languageTag
                            "fr", // language
                            "DZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-FR", // languageTag
                            "fr", // language
                            "FR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-GA", // languageTag
                            "fr", // language
                            "GA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-GF", // languageTag
                            "fr", // language
                            "GF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-GN", // languageTag
                            "fr", // language
                            "GN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-GP", // languageTag
                            "fr", // language
                            "GP", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-GQ", // languageTag
                            "fr", // language
                            "GQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-HT", // languageTag
                            "fr", // language
                            "HT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-KM", // languageTag
                            "fr", // language
                            "KM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-LU", // languageTag
                            "fr", // language
                            "LU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-MA", // languageTag
                            "fr", // language
                            "MA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-MC", // languageTag
                            "fr", // language
                            "MC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-MF", // languageTag
                            "fr", // language
                            "MF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-MG", // languageTag
                            "fr", // language
                            "MG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-ML", // languageTag
                            "fr", // language
                            "ML", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-MQ", // languageTag
                            "fr", // language
                            "MQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-MR", // languageTag
                            "fr", // language
                            "MR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-MU", // languageTag
                            "fr", // language
                            "MU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-NC", // languageTag
                            "fr", // language
                            "NC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-NE", // languageTag
                            "fr", // language
                            "NE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-PF", // languageTag
                            "fr", // language
                            "PF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-PM", // languageTag
                            "fr", // language
                            "PM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-RE", // languageTag
                            "fr", // language
                            "RE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-RW", // languageTag
                            "fr", // language
                            "RW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-SC", // languageTag
                            "fr", // language
                            "SC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-SN", // languageTag
                            "fr", // language
                            "SN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-SY", // languageTag
                            "fr", // language
                            "SY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-TD", // languageTag
                            "fr", // language
                            "TD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-TG", // languageTag
                            "fr", // language
                            "TG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-TN", // languageTag
                            "fr", // language
                            "TN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-VU", // languageTag
                            "fr", // language
                            "VU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-WF", // languageTag
                            "fr", // language
                            "WF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fr-YT", // languageTag
                            "fr", // language
                            "YT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fur", // languageTag
                            "fur", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fur-IT", // languageTag
                            "fur", // language
                            "IT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fy", // languageTag
                            "fy", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "fy-NL", // languageTag
                            "fy", // language
                            "NL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ga", // languageTag
                            "ga", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ga-IE", // languageTag
                            "ga", // language
                            "IE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gd", // languageTag
                            "gd", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gd-GB", // languageTag
                            "gd", // language
                            "GB", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gl", // languageTag
                            "gl", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gl-ES", // languageTag
                            "gl", // language
                            "ES", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gsw", // languageTag
                            "gsw", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gsw-CH", // languageTag
                            "gsw", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gsw-FR", // languageTag
                            "gsw", // language
                            "FR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gsw-LI", // languageTag
                            "gsw", // language
                            "LI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gu", // languageTag
                            "gu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gu-IN", // languageTag
                            "gu", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "guz", // languageTag
                            "guz", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "guz-KE", // languageTag
                            "guz", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gv", // languageTag
                            "gv", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "gv-IM", // languageTag
                            "gv", // language
                            "IM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ha", // languageTag
                            "ha", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ha-GH", // languageTag
                            "ha", // language
                            "GH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ha-NE", // languageTag
                            "ha", // language
                            "NE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ha-NG", // languageTag
                            "ha", // language
                            "NG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "haw", // languageTag
                            "haw", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "haw-US", // languageTag
                            "haw", // language
                            "US", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "he", // languageTag
                            "iw", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "he-IL", // languageTag
                            "iw", // language
                            "IL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hi", // languageTag
                            "hi", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hi-IN", // languageTag
                            "hi", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hr", // languageTag
                            "hr", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hr-BA", // languageTag
                            "hr", // language
                            "BA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hr-HR", // languageTag
                            "hr", // language
                            "HR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hsb", // languageTag
                            "hsb", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hsb-DE", // languageTag
                            "hsb", // language
                            "DE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hu", // languageTag
                            "hu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hu-HU", // languageTag
                            "hu", // language
                            "HU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hy", // languageTag
                            "hy", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "hy-AM", // languageTag
                            "hy", // language
                            "AM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "id", // languageTag
                            "in", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "id-ID", // languageTag
                            "in", // language
                            "ID", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ig", // languageTag
                            "ig", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ig-NG", // languageTag
                            "ig", // language
                            "NG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ii", // languageTag
                            "ii", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ii-CN", // languageTag
                            "ii", // language
                            "CN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "in", // languageTag
                            "in", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "in-ID", // languageTag
                            "in", // language
                            "ID", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "is", // languageTag
                            "is", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "is-IS", // languageTag
                            "is", // language
                            "IS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "it", // languageTag
                            "it", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "it-CH", // languageTag
                            "it", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "it-IT", // languageTag
                            "it", // language
                            "IT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "it-SM", // languageTag
                            "it", // language
                            "SM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "iw", // languageTag
                            "iw", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "iw-IL", // languageTag
                            "iw", // language
                            "IL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ja", // languageTag
                            "ja", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ja-JP", // languageTag
                            "ja", // language
                            "JP", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "jgo", // languageTag
                            "jgo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "jgo-CM", // languageTag
                            "jgo", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ji", // languageTag
                            "ji", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ji-001", // languageTag
                            "ji", // language
                            "001", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "jmc", // languageTag
                            "jmc", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "jmc-TZ", // languageTag
                            "jmc", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ka", // languageTag
                            "ka", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ka-GE", // languageTag
                            "ka", // language
                            "GE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kab", // languageTag
                            "kab", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kab-DZ", // languageTag
                            "kab", // language
                            "DZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kam", // languageTag
                            "kam", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kam-KE", // languageTag
                            "kam", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kde", // languageTag
                            "kde", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kde-TZ", // languageTag
                            "kde", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kea", // languageTag
                            "kea", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kea-CV", // languageTag
                            "kea", // language
                            "CV", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "khq", // languageTag
                            "khq", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "khq-ML", // languageTag
                            "khq", // language
                            "ML", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ki", // languageTag
                            "ki", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ki-KE", // languageTag
                            "ki", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kk", // languageTag
                            "kk", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kk-KZ", // languageTag
                            "kk", // language
                            "KZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kkj", // languageTag
                            "kkj", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kkj-CM", // languageTag
                            "kkj", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kl", // languageTag
                            "kl", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kl-GL", // languageTag
                            "kl", // language
                            "GL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kln", // languageTag
                            "kln", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kln-KE", // languageTag
                            "kln", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "km", // languageTag
                            "km", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "km-KH", // languageTag
                            "km", // language
                            "KH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kn", // languageTag
                            "kn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kn-IN", // languageTag
                            "kn", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ko", // languageTag
                            "ko", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ko-KP", // languageTag
                            "ko", // language
                            "KP", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ko-KR", // languageTag
                            "ko", // language
                            "KR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kok", // languageTag
                            "kok", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kok-IN", // languageTag
                            "kok", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ks", // languageTag
                            "ks", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ks-IN", // languageTag
                            "ks", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ksb", // languageTag
                            "ksb", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ksb-TZ", // languageTag
                            "ksb", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ksf", // languageTag
                            "ksf", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ksf-CM", // languageTag
                            "ksf", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ksh", // languageTag
                            "ksh", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ksh-DE", // languageTag
                            "ksh", // language
                            "DE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kw", // languageTag
                            "kw", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "kw-GB", // languageTag
                            "kw", // language
                            "GB", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ky", // languageTag
                            "ky", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ky-KG", // languageTag
                            "ky", // language
                            "KG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lag", // languageTag
                            "lag", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lag-TZ", // languageTag
                            "lag", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lb", // languageTag
                            "lb", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lb-LU", // languageTag
                            "lb", // language
                            "LU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lg", // languageTag
                            "lg", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lg-UG", // languageTag
                            "lg", // language
                            "UG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lkt", // languageTag
                            "lkt", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lkt-US", // languageTag
                            "lkt", // language
                            "US", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ln", // languageTag
                            "ln", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ln-AO", // languageTag
                            "ln", // language
                            "AO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ln-CD", // languageTag
                            "ln", // language
                            "CD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ln-CF", // languageTag
                            "ln", // language
                            "CF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ln-CG", // languageTag
                            "ln", // language
                            "CG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lo", // languageTag
                            "lo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lo-LA", // languageTag
                            "lo", // language
                            "LA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lrc", // languageTag
                            "lrc", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lrc-IQ", // languageTag
                            "lrc", // language
                            "IQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lrc-IR", // languageTag
                            "lrc", // language
                            "IR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lt", // languageTag
                            "lt", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lt-LT", // languageTag
                            "lt", // language
                            "LT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lu", // languageTag
                            "lu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lu-CD", // languageTag
                            "lu", // language
                            "CD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "luo", // languageTag
                            "luo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "luo-KE", // languageTag
                            "luo", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "luy", // languageTag
                            "luy", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "luy-KE", // languageTag
                            "luy", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lv", // languageTag
                            "lv", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "lv-LV", // languageTag
                            "lv", // language
                            "LV", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mas", // languageTag
                            "mas", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mas-KE", // languageTag
                            "mas", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mas-TZ", // languageTag
                            "mas", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mer", // languageTag
                            "mer", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mer-KE", // languageTag
                            "mer", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mfe", // languageTag
                            "mfe", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mfe-MU", // languageTag
                            "mfe", // language
                            "MU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mg", // languageTag
                            "mg", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mg-MG", // languageTag
                            "mg", // language
                            "MG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mgh", // languageTag
                            "mgh", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mgh-MZ", // languageTag
                            "mgh", // language
                            "MZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mgo", // languageTag
                            "mgo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mgo-CM", // languageTag
                            "mgo", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mk", // languageTag
                            "mk", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mk-MK", // languageTag
                            "mk", // language
                            "MK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ml", // languageTag
                            "ml", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ml-IN", // languageTag
                            "ml", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mn", // languageTag
                            "mn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mn-MN", // languageTag
                            "mn", // language
                            "MN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mr", // languageTag
                            "mr", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mr-IN", // languageTag
                            "mr", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ms", // languageTag
                            "ms", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ms-BN", // languageTag
                            "ms", // language
                            "BN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ms-MY", // languageTag
                            "ms", // language
                            "MY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ms-SG", // languageTag
                            "ms", // language
                            "SG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mt", // languageTag
                            "mt", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mt-MT", // languageTag
                            "mt", // language
                            "MT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mua", // languageTag
                            "mua", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mua-CM", // languageTag
                            "mua", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "my", // languageTag
                            "my", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "my-MM", // languageTag
                            "my", // language
                            "MM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mzn", // languageTag
                            "mzn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "mzn-IR", // languageTag
                            "mzn", // language
                            "IR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "naq", // languageTag
                            "naq", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "naq-NA", // languageTag
                            "naq", // language
                            "NA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nb", // languageTag
                            "nb", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nb-NO", // languageTag
                            "nb", // language
                            "NO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nb-SJ", // languageTag
                            "nb", // language
                            "SJ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nd", // languageTag
                            "nd", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nd-ZW", // languageTag
                            "nd", // language
                            "ZW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ne", // languageTag
                            "ne", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ne-IN", // languageTag
                            "ne", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ne-NP", // languageTag
                            "ne", // language
                            "NP", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl", // languageTag
                            "nl", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl-AW", // languageTag
                            "nl", // language
                            "AW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl-BE", // languageTag
                            "nl", // language
                            "BE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl-BQ", // languageTag
                            "nl", // language
                            "BQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl-CW", // languageTag
                            "nl", // language
                            "CW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl-NL", // languageTag
                            "nl", // language
                            "NL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl-SR", // languageTag
                            "nl", // language
                            "SR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nl-SX", // languageTag
                            "nl", // language
                            "SX", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nmg", // languageTag
                            "nmg", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nmg-CM", // languageTag
                            "nmg", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nn", // languageTag
                            "nn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nn-NO", // languageTag
                            "nn", // language
                            "NO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nn-NO", // languageTag
                            "no", // language
                            "NO", // country
                            "NY", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nnh", // languageTag
                            "nnh", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nnh-CM", // languageTag
                            "nnh", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "no", // languageTag
                            "no", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "no-NO", // languageTag
                            "no", // language
                            "NO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "no-NO-NY", // languageTag
                            "no", // language
                            "NO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nus", // languageTag
                            "nus", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nus-SS", // languageTag
                            "nus", // language
                            "SS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nyn", // languageTag
                            "nyn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "nyn-UG", // languageTag
                            "nyn", // language
                            "UG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "om", // languageTag
                            "om", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "om-ET", // languageTag
                            "om", // language
                            "ET", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "om-KE", // languageTag
                            "om", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "or", // languageTag
                            "or", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "or-IN", // languageTag
                            "or", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "os", // languageTag
                            "os", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "os-GE", // languageTag
                            "os", // language
                            "GE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "os-RU", // languageTag
                            "os", // language
                            "RU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pa", // languageTag
                            "pa", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pa-Arab", // languageTag
                            "pa", // language
                            "", // country
                            "", // variant
                            "Arab") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pa-Arab-PK", // languageTag
                            "pa", // language
                            "PK", // country
                            "", // variant
                            "Arab") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pa-Guru", // languageTag
                            "pa", // language
                            "", // country
                            "", // variant
                            "Guru") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pa-Guru-IN", // languageTag
                            "pa", // language
                            "IN", // country
                            "", // variant
                            "Guru") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pa-IN", // languageTag
                            "pa", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pa-PK", // languageTag
                            "pa", // language
                            "PK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pl", // languageTag
                            "pl", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pl-PL", // languageTag
                            "pl", // language
                            "PL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "prg", // languageTag
                            "prg", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "prg-001", // languageTag
                            "prg", // language
                            "001", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ps", // languageTag
                            "ps", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ps-AF", // languageTag
                            "ps", // language
                            "AF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt", // languageTag
                            "pt", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-AO", // languageTag
                            "pt", // language
                            "AO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-BR", // languageTag
                            "pt", // language
                            "BR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-CH", // languageTag
                            "pt", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-CV", // languageTag
                            "pt", // language
                            "CV", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-GQ", // languageTag
                            "pt", // language
                            "GQ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-GW", // languageTag
                            "pt", // language
                            "GW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-LU", // languageTag
                            "pt", // language
                            "LU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-MO", // languageTag
                            "pt", // language
                            "MO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-MZ", // languageTag
                            "pt", // language
                            "MZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-PT", // languageTag
                            "pt", // language
                            "PT", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-ST", // languageTag
                            "pt", // language
                            "ST", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "pt-TL", // languageTag
                            "pt", // language
                            "TL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "qu", // languageTag
                            "qu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "qu-BO", // languageTag
                            "qu", // language
                            "BO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "qu-EC", // languageTag
                            "qu", // language
                            "EC", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "qu-PE", // languageTag
                            "qu", // language
                            "PE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rm", // languageTag
                            "rm", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rm-CH", // languageTag
                            "rm", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rn", // languageTag
                            "rn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rn-BI", // languageTag
                            "rn", // language
                            "BI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ro", // languageTag
                            "ro", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ro-MD", // languageTag
                            "ro", // language
                            "MD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ro-RO", // languageTag
                            "ro", // language
                            "RO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rof", // languageTag
                            "rof", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rof-TZ", // languageTag
                            "rof", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ru", // languageTag
                            "ru", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ru-BY", // languageTag
                            "ru", // language
                            "BY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ru-KG", // languageTag
                            "ru", // language
                            "KG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ru-KZ", // languageTag
                            "ru", // language
                            "KZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ru-MD", // languageTag
                            "ru", // language
                            "MD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ru-RU", // languageTag
                            "ru", // language
                            "RU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ru-UA", // languageTag
                            "ru", // language
                            "UA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rw", // languageTag
                            "rw", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rw-RW", // languageTag
                            "rw", // language
                            "RW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rwk", // languageTag
                            "rwk", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "rwk-TZ", // languageTag
                            "rwk", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sah", // languageTag
                            "sah", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sah-RU", // languageTag
                            "sah", // language
                            "RU", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "saq", // languageTag
                            "saq", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "saq-KE", // languageTag
                            "saq", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sbp", // languageTag
                            "sbp", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sbp-TZ", // languageTag
                            "sbp", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "se", // languageTag
                            "se", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "se-FI", // languageTag
                            "se", // language
                            "FI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "se-NO", // languageTag
                            "se", // language
                            "NO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "se-SE", // languageTag
                            "se", // language
                            "SE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "seh", // languageTag
                            "seh", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "seh-MZ", // languageTag
                            "seh", // language
                            "MZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ses", // languageTag
                            "ses", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ses-ML", // languageTag
                            "ses", // language
                            "ML", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sg", // languageTag
                            "sg", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sg-CF", // languageTag
                            "sg", // language
                            "CF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "shi", // languageTag
                            "shi", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "shi-Latn", // languageTag
                            "shi", // language
                            "", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "shi-Latn-MA", // languageTag
                            "shi", // language
                            "MA", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "shi-MA", // languageTag
                            "shi", // language
                            "MA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "shi-Tfng", // languageTag
                            "shi", // language
                            "", // country
                            "", // variant
                            "Tfng") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "shi-Tfng-MA", // languageTag
                            "shi", // language
                            "MA", // country
                            "", // variant
                            "Tfng") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "si", // languageTag
                            "si", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "si-LK", // languageTag
                            "si", // language
                            "LK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sk", // languageTag
                            "sk", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sk-SK", // languageTag
                            "sk", // language
                            "SK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sl", // languageTag
                            "sl", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sl-SI", // languageTag
                            "sl", // language
                            "SI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "smn", // languageTag
                            "smn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "smn-FI", // languageTag
                            "smn", // language
                            "FI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sn", // languageTag
                            "sn", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sn-ZW", // languageTag
                            "sn", // language
                            "ZW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "so", // languageTag
                            "so", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "so-DJ", // languageTag
                            "so", // language
                            "DJ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "so-ET", // languageTag
                            "so", // language
                            "ET", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "so-KE", // languageTag
                            "so", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "so-SO", // languageTag
                            "so", // language
                            "SO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sq", // languageTag
                            "sq", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sq-AL", // languageTag
                            "sq", // language
                            "AL", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sq-MK", // languageTag
                            "sq", // language
                            "MK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sq-XK", // languageTag
                            "sq", // language
                            "XK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr", // languageTag
                            "sr", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-BA", // languageTag
                            "sr", // language
                            "BA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-CS", // languageTag
                            "sr", // language
                            "CS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Cyrl", // languageTag
                            "sr", // language
                            "", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Cyrl-BA", // languageTag
                            "sr", // language
                            "BA", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Cyrl-ME", // languageTag
                            "sr", // language
                            "ME", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Cyrl-RS", // languageTag
                            "sr", // language
                            "RS", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Cyrl-XK", // languageTag
                            "sr", // language
                            "XK", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Latn", // languageTag
                            "sr", // language
                            "", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Latn-BA", // languageTag
                            "sr", // language
                            "BA", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Latn-ME", // languageTag
                            "sr", // language
                            "ME", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Latn-RS", // languageTag
                            "sr", // language
                            "RS", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-Latn-XK", // languageTag
                            "sr", // language
                            "XK", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-ME", // languageTag
                            "sr", // language
                            "ME", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sr-RS", // languageTag
                            "sr", // language
                            "RS", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sv", // languageTag
                            "sv", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sv-AX", // languageTag
                            "sv", // language
                            "AX", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sv-FI", // languageTag
                            "sv", // language
                            "FI", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sv-SE", // languageTag
                            "sv", // language
                            "SE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sw", // languageTag
                            "sw", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sw-CD", // languageTag
                            "sw", // language
                            "CD", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sw-KE", // languageTag
                            "sw", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sw-TZ", // languageTag
                            "sw", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "sw-UG", // languageTag
                            "sw", // language
                            "UG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ta", // languageTag
                            "ta", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ta-IN", // languageTag
                            "ta", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ta-LK", // languageTag
                            "ta", // language
                            "LK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ta-MY", // languageTag
                            "ta", // language
                            "MY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ta-SG", // languageTag
                            "ta", // language
                            "SG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "te", // languageTag
                            "te", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "te-IN", // languageTag
                            "te", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "teo", // languageTag
                            "teo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "teo-KE", // languageTag
                            "teo", // language
                            "KE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "teo-UG", // languageTag
                            "teo", // language
                            "UG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "th", // languageTag
                            "th", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "th-TH", // languageTag
                            "th", // language
                            "TH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ti", // languageTag
                            "ti", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ti-ER", // languageTag
                            "ti", // language
                            "ER", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ti-ET", // languageTag
                            "ti", // language
                            "ET", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "tk", // languageTag
                            "tk", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "tk-TM", // languageTag
                            "tk", // language
                            "TM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "to", // languageTag
                            "to", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "to-TO", // languageTag
                            "to", // language
                            "TO", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "tr", // languageTag
                            "tr", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "tr-CY", // languageTag
                            "tr", // language
                            "CY", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "tr-TR", // languageTag
                            "tr", // language
                            "TR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "twq", // languageTag
                            "twq", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "twq-NE", // languageTag
                            "twq", // language
                            "NE", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "tzm", // languageTag
                            "tzm", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "tzm-MA", // languageTag
                            "tzm", // language
                            "MA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ug", // languageTag
                            "ug", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ug-CN", // languageTag
                            "ug", // language
                            "CN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uk", // languageTag
                            "uk", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uk-UA", // languageTag
                            "uk", // language
                            "UA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "und", // languageTag
                            "", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ur", // languageTag
                            "ur", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ur-IN", // languageTag
                            "ur", // language
                            "IN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "ur-PK", // languageTag
                            "ur", // language
                            "PK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz", // languageTag
                            "uz", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-AF", // languageTag
                            "uz", // language
                            "AF", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-Arab", // languageTag
                            "uz", // language
                            "", // country
                            "", // variant
                            "Arab") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-Arab-AF", // languageTag
                            "uz", // language
                            "AF", // country
                            "", // variant
                            "Arab") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-Cyrl", // languageTag
                            "uz", // language
                            "", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-Cyrl-UZ", // languageTag
                            "uz", // language
                            "UZ", // country
                            "", // variant
                            "Cyrl") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-Latn", // languageTag
                            "uz", // language
                            "", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-Latn-UZ", // languageTag
                            "uz", // language
                            "UZ", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "uz-UZ", // languageTag
                            "uz", // language
                            "UZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vai", // languageTag
                            "vai", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vai-LR", // languageTag
                            "vai", // language
                            "LR", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vai-Latn", // languageTag
                            "vai", // language
                            "", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vai-Latn-LR", // languageTag
                            "vai", // language
                            "LR", // country
                            "", // variant
                            "Latn") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vai-Vaii", // languageTag
                            "vai", // language
                            "", // country
                            "", // variant
                            "Vaii") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vai-Vaii-LR", // languageTag
                            "vai", // language
                            "LR", // country
                            "", // variant
                            "Vaii") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vi", // languageTag
                            "vi", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vi-VN", // languageTag
                            "vi", // language
                            "VN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vo", // languageTag
                            "vo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vo-001", // languageTag
                            "vo", // language
                            "001", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vun", // languageTag
                            "vun", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "vun-TZ", // languageTag
                            "vun", // language
                            "TZ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "wae", // languageTag
                            "wae", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "wae-CH", // languageTag
                            "wae", // language
                            "CH", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "xog", // languageTag
                            "xog", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "xog-UG", // languageTag
                            "xog", // language
                            "UG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yav", // languageTag
                            "yav", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yav-CM", // languageTag
                            "yav", // language
                            "CM", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yi", // languageTag
                            "ji", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yi-001", // languageTag
                            "ji", // language
                            "001", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yo", // languageTag
                            "yo", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yo-BJ", // languageTag
                            "yo", // language
                            "BJ", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yo-NG", // languageTag
                            "yo", // language
                            "NG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yue", // languageTag
                            "yue", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "yue-HK", // languageTag
                            "yue", // language
                            "HK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zgh", // languageTag
                            "zgh", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zgh-MA", // languageTag
                            "zgh", // language
                            "MA", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh", // languageTag
                            "zh", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-CN", // languageTag
                            "zh", // language
                            "CN", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-HK", // languageTag
                            "zh", // language
                            "HK", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hans", // languageTag
                            "zh", // language
                            "", // country
                            "", // variant
                            "Hans") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hans-CN", // languageTag
                            "zh", // language
                            "CN", // country
                            "", // variant
                            "Hans") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hans-HK", // languageTag
                            "zh", // language
                            "HK", // country
                            "", // variant
                            "Hans") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hans-MO", // languageTag
                            "zh", // language
                            "MO", // country
                            "", // variant
                            "Hans") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hans-SG", // languageTag
                            "zh", // language
                            "SG", // country
                            "", // variant
                            "Hans") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hant", // languageTag
                            "zh", // language
                            "", // country
                            "", // variant
                            "Hant") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hant-HK", // languageTag
                            "zh", // language
                            "HK", // country
                            "", // variant
                            "Hant") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hant-MO", // languageTag
                            "zh", // language
                            "MO", // country
                            "", // variant
                            "Hant") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-Hant-TW", // languageTag
                            "zh", // language
                            "TW", // country
                            "", // variant
                            "Hant") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-SG", // languageTag
                            "zh", // language
                            "SG", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zh-TW", // languageTag
                            "zh", // language
                            "TW", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zu", // languageTag
                            "zu", // language
                            "", // country
                            "", // variant
                            "") // script
            ),
            WalkingkookaLocale.with(
                    WalkingkookaLanguageTag.with(
                            "zu-ZA", // languageTag
                            "zu", // language
                            "ZA", // country
                            "", // variant
                            "") // script
            ));

    /**
     * Factory that parses and creates a {@link WalkingkookaLocale} from a language tag.
     */
    static WalkingkookaLocale with(final WalkingkookaLanguageTag tag) {
        return new WalkingkookaLocale(tag);
    }

    private WalkingkookaLocale(final WalkingkookaLanguageTag tag) {
        super();

        this.languageTag = tag;
    }

    // Locale...........................................................................................................

    private boolean test(final WalkingkookaLanguageTag other) {
        return this.languageTag().equals(other);
    }

    public WalkingkookaLanguageTag languageTag() {
        return this.languageTag;
    }

    private WalkingkookaLanguageTag languageTag;

    // Object...........................................................................................................

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .value(this.languageTag)
                .build();
    }
}
