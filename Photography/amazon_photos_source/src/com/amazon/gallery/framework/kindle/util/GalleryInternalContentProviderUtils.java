// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class GalleryInternalContentProviderUtils
{

    public static String getTagLabel(ContentResolver contentresolver, Uri uri)
    {
        Uri uri1;
        Object obj;
        obj = null;
        uri1 = null;
        uri = contentresolver.query(uri, null, null, null, null);
        contentresolver = obj;
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        contentresolver = obj;
        uri1 = uri;
        if (!uri.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        uri1 = uri;
        contentresolver = uri.getString(uri.getColumnIndex("label"));
        if (uri != null)
        {
            uri.close();
        }
        uri = contentresolver;
        if (contentresolver == null)
        {
            uri = "";
        }
        return uri;
        contentresolver;
        if (uri1 != null)
        {
            uri1.close();
        }
        throw contentresolver;
    }
}
