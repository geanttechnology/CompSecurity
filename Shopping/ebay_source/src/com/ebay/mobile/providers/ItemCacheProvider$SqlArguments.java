// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.providers;

import android.content.ContentUris;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

// Referenced classes of package com.ebay.mobile.providers:
//            ItemCacheProvider

private static class args
{

    public final String args[];
    public final String table;
    public final String where;

    (Uri uri)
    {
        if (uri.getPathSegments().size() == 1)
        {
            table = (String)uri.getPathSegments().get(0);
            where = null;
            args = null;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid URI: ").append(uri).toString());
        }
    }

    args(Uri uri, String s, String as[])
    {
        if (uri.getPathSegments().size() == 1)
        {
            table = (String)uri.getPathSegments().get(0);
            where = s;
            args = as;
            return;
        }
        if (uri.getPathSegments().size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid URI: ").append(uri).toString());
        }
        if (!TextUtils.isEmpty(s))
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("WHERE clause not supported: ").append(uri).toString());
        } else
        {
            table = (String)uri.getPathSegments().get(0);
            where = (new StringBuilder()).append("id=").append(ContentUris.parseId(uri)).toString();
            args = null;
            return;
        }
    }
}
