// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.media;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.io.File;

public final class MediaUtils
{

    private MediaUtils()
    {
    }

    public static Uri insertImage(Context context, File file)
        throws IllegalStateException
    {
        if (file == null)
        {
            return null;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("_data", file.getAbsolutePath());
            contentvalues.put("date_added", Long.valueOf(System.currentTimeMillis()));
            contentvalues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentvalues.put("description", "Edited with Aviary");
            return context.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentvalues);
        }
    }

    public static Uri normalizeUri(Uri uri)
    {
        if (uri == null)
        {
            uri = null;
        } else
        {
            String s = uri.getScheme();
            String s1 = uri.getPath();
            if (s == null)
            {
                return Uri.parse((new StringBuilder()).append("file://").append(s1).toString());
            }
        }
        return uri;
    }
}
