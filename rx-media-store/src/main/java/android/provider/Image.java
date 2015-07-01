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

import android.database.Cursor;
import android.os.Parcelable;

import auto.cursor.*;
import android.content.ContentUris;
import android.net.Uri;

@AutoCursor
public abstract class Image implements Parcelable, ImageColumns {
    public static Image create(Cursor cursor) {
        return new AutoCursor_Image(cursor);
    }

    public Uri getExternalContentUri() {
        return ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id());
        // alternative:
        // return Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(String.valueOf(id())).build();
    }

    public Uri getContentUri() {
        return getExternalContentUri();
    }
}
