/*
 * Copyright (C) 2015 8tory, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.provider;

import auto.cursor.*;

import android.support.annotation.Nullable;
import static android.provider.MediaStore.MediaColumns.*;

public interface MediaColumns extends IBaseColumns {
    @Nullable
    @AutoCursor.Column(name = DATA)
    public abstract String data();

    @Nullable
    @AutoCursor.Column(name = DATE_ADDED)
    public abstract Long dateAdded();

    @Nullable
    @AutoCursor.Column(name = DATE_MODIFIED)
    public abstract Long dateModified();

    @Nullable
    @AutoCursor.Column(name = DISPLAY_NAME)
    public abstract String displayName();

    @Nullable
    @AutoCursor.Column(name = HEIGHT)
    public abstract Integer height();

    @Nullable
    @AutoCursor.Column(name = MIME_TYPE)
    public abstract String mimeType();

    @Nullable
    @AutoCursor.Column(name = SIZE)
    public abstract Long size();

    @Nullable
    @AutoCursor.Column(name = TITLE)
    public abstract String title();

    @Nullable
    @AutoCursor.Column(name = WIDTH)
    public abstract Integer width();
}
