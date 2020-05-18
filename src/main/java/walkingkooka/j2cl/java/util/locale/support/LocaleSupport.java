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

import walkingkooka.reflect.PublicStaticHelper;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;

public final class LocaleSupport implements PublicStaticHelper {

    public static Locale read(final DataInput data) throws IOException {
        return Locale.forLanguageTag(data.readUTF());
    }

    public static void write(final Locale locale,
                             final DataOutput data) throws IOException {
        data.writeUTF(locale.toLanguageTag());
    }

    private LocaleSupport() {
        throw new UnsupportedOperationException();
    }
}
