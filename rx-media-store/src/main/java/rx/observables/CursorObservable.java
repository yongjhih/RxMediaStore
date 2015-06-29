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

package rx.observables;

import android.database.Cursor;
import android.provider.Image;
import android.net.Uri;

import rx.Observable;
import rx.functions.*;

import android.provider.MediaStore.Images;
import android.content.Context;

public class CursorObservable {
    public static Observable<Cursor> create(Cursor cursor) {
        return Observable.create(sub -> {
            try {
                while (cursor.moveToNext()) {
                    sub.onNext(cursor);
                }
                sub.onCompleted();
            } catch (Exception e) {
                sub.onError(e);
            }
        });
    }

    /* TODO Video
    public Observable<Video> videos(Context context) {
        return Observable.create(QueryBuilder.create(context).uri(Video.Media.EXTERNAL_CONTENT_URI).build());
    }
    */

    public static Observable<Image> images(Context context) {
        return create(new Select().from(context, Images.Media.EXTERNAL_CONTENT_URI).query()).map(c -> Image.create(c));
    }

    public static class QueryBuilder {
        Context context = null;
        Uri uri = null;
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        public static QueryBuilder create() {
            return new QueryBuilder();
        }

        public static QueryBuilder create(Context context) {
            return new QueryBuilder(context);
        }

        public QueryBuilder() {
            this(null);
        }

        public QueryBuilder(Context context) {
            this.context = context;
        }

        public QueryBuilder uri(Uri uri) {
            this.uri = uri;
            return this;
        }
        public QueryBuilder projection(String[] projection) {
            this.projection = projection;
            return this;
        }
        public QueryBuilder selection(String selection) {
            this.selection = selection;
            return this;
        }
        public QueryBuilder selectionArgs(String[] selectionArgs) {
            this.selectionArgs = selectionArgs;
            return this;
        }
        public QueryBuilder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public Uri uri() {
            return uri;
        }
        public String[] projection() {
            return projection;
        }
        public String selection() {
            return selection;
        }
        public String[] selectionArgs() {
            return selectionArgs;
        }
        public String sortOrder() {
            return sortOrder;
        }

        public Cursor build() {
            if (context == null) return null;
            return context.getContentResolver().query(
                    uri(),
                    projection(),
                    selection(),
                    selectionArgs(),
                    sortOrder());
        }
    }

    public static class Select {
        Context context = null;
        Uri uri = null;
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        public Select(String... projection) {
            projection(projection);
        }

        public Select() {
            projection(null);
        }

        public Select from(Uri uri, Context context) {
            return from(context, uri);
        }

        public Select from(Context context, Uri uri) {
            this.context = context;

            return uri(uri);
        }

        public Select where(String selection, String[] selectionArgs) {
            return selection(selection).selectionArgs(selectionArgs);
        }

        public Select uri(Uri uri) {
            this.uri = uri;
            return this;
        }
        public Select projection(String[] projection) {
            this.projection = projection;
            return this;
        }
        public Select selection(String selection) {
            this.selection = selection;
            return this;
        }
        public Select selectionArgs(String[] selectionArgs) {
            this.selectionArgs = selectionArgs;
            return this;
        }
        public Select sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public Uri uri() {
            return uri;
        }
        public String[] projection() {
            return projection;
        }
        public String selection() {
            return selection;
        }
        public String[] selectionArgs() {
            return selectionArgs;
        }
        public String sortOrder() {
            return sortOrder;
        }

        public Cursor query() {
            if (context == null) return null;
            return context.getContentResolver().query(
                    uri(),
                    projection(),
                    selection(),
                    selectionArgs(),
                    sortOrder());
        }
    }
}
