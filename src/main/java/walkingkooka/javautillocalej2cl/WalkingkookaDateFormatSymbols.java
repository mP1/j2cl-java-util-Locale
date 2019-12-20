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

import walkingkooka.ToStringBuilder;

import java.util.List;

/**
 * A record that should only be used to populate the JRE emulated java.text.DateFormatSymbols
 */
public final class WalkingkookaDateFormatSymbols {

    static WalkingkookaDateFormatSymbols with(final List<String> ampm,
                                              final List<String> eras,
                                              final List<String> months,
                                              final List<String> shortMonths,
                                              final List<String> shortWeekdays,
                                              final List<String> weekdays) {
        return new WalkingkookaDateFormatSymbols(ampm,
                eras,
                months,
                shortMonths,
                shortWeekdays,
                weekdays);
    }

    private WalkingkookaDateFormatSymbols(final List<String> ampm,
                                          final List<String> eras,
                                          final List<String> months,
                                          final List<String> shortMonths,
                                          final List<String> shortWeekdays,
                                          final List<String> weekdays) {
        super();
        this.ampm = ampm;
        this.eras = eras;
        this.months = months;
        this.shortMonths = shortMonths;
        this.shortWeekdays = shortWeekdays;
        this.weekdays = weekdays;
    }

    public String[] ampm() {
        return this.stringArray(this.ampm);
    }

    private final List<String> ampm;

    public String[] eras() {
        return this.stringArray(this.eras);
    }

    private final List<String> eras;

    public String[] months() {
        return this.stringArray(this.months);
    }

    private final List<String> months;

    public String[] shortMonths() {
        return this.stringArray(this.shortMonths);
    }

    private final List<String> shortMonths;

    public String[] shortWeekdays() {
        return this.stringArray(this.shortWeekdays);
    }

    private final List<String> shortWeekdays;

    public String[] weekdays() {
        return this.stringArray(this.weekdays);
    }

    private final List<String> weekdays;

    private static String[] stringArray(final List<String> strings) {
        return strings.toArray(new String[strings.size()]);
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("ampm").value(this.ampm())
                .label("eras").value(this.eras())
                .label("months").value(this.months())
                .label("shortMonths").value(this.shortMonths())
                .label("shortWeekdays").value(this.shortWeekdays())
                .label("weekdays").value(this.weekdays())
                .build();
    }
}
