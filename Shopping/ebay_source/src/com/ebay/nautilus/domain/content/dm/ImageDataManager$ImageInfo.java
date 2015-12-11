// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.graphics.Bitmap;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ImageDataManager

public static final class loadToken
{

    public final boolean fromCache;
    public final Bitmap image;
    public final loadToken loadToken;
    public final String url;

    public ( ,  1)
    {
        this(.url, .image, .fromCache, 1);
    }

    public fromCache(String s, Bitmap bitmap, boolean flag, fromCache fromcache)
    {
        url = s;
        image = bitmap;
        fromCache = flag;
        loadToken = fromcache;
    }
}
