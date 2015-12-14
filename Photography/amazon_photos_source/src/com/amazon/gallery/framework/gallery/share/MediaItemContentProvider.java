// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.share;

import android.content.ContentProvider;
import android.content.UriMatcher;

public abstract class MediaItemContentProvider extends ContentProvider
    implements android.provider.MediaStore.MediaColumns
{
    public static final class MEDIA_URI extends Enum
    {

        private static final MEDIA_URI $VALUES[];
        public static final MEDIA_URI media;
        public static final MEDIA_URI tag;

        public static MEDIA_URI valueOf(String s)
        {
            return (MEDIA_URI)Enum.valueOf(com/amazon/gallery/framework/gallery/share/MediaItemContentProvider$MEDIA_URI, s);
        }

        public static MEDIA_URI[] values()
        {
            return (MEDIA_URI[])$VALUES.clone();
        }

        static 
        {
            media = new MEDIA_URI("media", 0);
            tag = new MEDIA_URI("tag", 1);
            $VALUES = (new MEDIA_URI[] {
                media, tag
            });
        }

        private MEDIA_URI(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String PROJ_ALL[] = {
        "_count", "_id", "_data", "date_added", "date_modified", "_display_name", "height", "mime_type", "_size", "title", 
        "width"
    };
    public static final String TAG = com/amazon/gallery/framework/gallery/share/MediaItemContentProvider.getName();
    protected static final UriMatcher mUriMatcher = new UriMatcher(-1);

    public MediaItemContentProvider()
    {
        mUriMatcher.addURI("com.amazon.gallery.provider", (new StringBuilder()).append(MEDIA_URI.tag.name()).append("/*").toString(), 1);
        mUriMatcher.addURI("com.amazon.gallery.provider", (new StringBuilder()).append(MEDIA_URI.media.name()).append("/all").toString(), 3);
        mUriMatcher.addURI("com.amazon.gallery.provider", (new StringBuilder()).append(MEDIA_URI.media.name()).append("/*").toString(), 2);
    }

}
