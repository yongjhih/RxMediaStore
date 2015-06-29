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
import static android.provider.MediaStore.Images.ImageColumns.*;

public interface ImageColumns extends MediaColumns {
    @Nullable
    @AutoCursor.Column(name = BUCKET_DISPLAY_NAME)
    public String bucketDisplayName();

    @Nullable
    @AutoCursor.Column(name = BUCKET_ID)
    public String bucketId();

    @Nullable
    @AutoCursor.Column(name = DATE_TAKEN)
    public Long dateTaken();

    @Nullable
    @AutoCursor.Column(name = DESCRIPTION)
    public String description();

    @Nullable
    @AutoCursor.Column(name = IS_PRIVATE)
    public Boolean isPrivate();

    @Nullable
    @AutoCursor.Column(name = LATITUDE)
    public Double latitude();

    @Nullable
    @AutoCursor.Column(name = LONGITUDE)
    public Double longitude();

    @Nullable
    @AutoCursor.Column(name = MINI_THUMB_MAGIC)
    public String  miniThumbMagic();

    @Nullable
    @AutoCursor.Column(name = ORIENTATION)
    public Integer orientation();

    @Nullable
    @AutoCursor.Column(name = PICASA_ID)
    public String picasaId();
}
