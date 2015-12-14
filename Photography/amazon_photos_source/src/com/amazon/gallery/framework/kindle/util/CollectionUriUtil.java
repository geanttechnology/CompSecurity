// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.amazon.gallery.framework.kindle.provider.FilterCollection;

// Referenced classes of package com.amazon.gallery.framework.kindle.util:
//            GalleryInternalContentProviderUtils

public class CollectionUriUtil
{

    public static String getLabelFromUri(Context context, Uri uri)
    {
        Object obj = context.getContentResolver();
        if (isCollectionUri(((ContentResolver) (obj)), uri))
        {
            uri = context.getString(FilterCollection.valueOf(uri).getLabelID());
        } else
        if (isTagUri(((ContentResolver) (obj)), uri))
        {
            obj = GalleryInternalContentProviderUtils.getTagLabel(((ContentResolver) (obj)), uri);
            uri = ((Uri) (obj));
            if (((String) (obj)).isEmpty())
            {
                return context.getString(0x7f0e009a);
            }
        } else
        {
            return "";
        }
        return uri;
    }

    public static boolean isCollectionUri(ContentResolver contentresolver, Uri uri)
    {
        return "vnd.android.cursor.item/collection".equals(contentresolver.getType(uri));
    }

    public static boolean isTagUri(ContentResolver contentresolver, Uri uri)
    {
        return "vnd.android.cursor.item/tag".equals(contentresolver.getType(uri));
    }
}
